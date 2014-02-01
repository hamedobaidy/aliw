 
package com.hamedapps.aliw.ui.part;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.swtchart.Chart;
import org.swtchart.IAxisSet;
import org.swtchart.ILineSeries;
import org.swtchart.ILineSeries.PlotSymbolType;
import org.swtchart.ISeries.SeriesType;
import org.swtchart.ISeriesSet;
import org.swtchart.Range;

import com.hamedapps.aliw.model.Etta;
import com.hamedapps.aliw.model.ProgressiveWave;


public class ProgressiveCanvasPart {
	
	@Inject
	private MApplication application;
	private Chart chart;
	
	
	@Inject
	public ProgressiveCanvasPart() {
		//TODO Your code here
	}
	
	@PostConstruct
	public void postConstruct(Composite parent) {
		parent.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		chart = new Chart(scrolledComposite, SWT.NONE);
		chart.getTitle().setText("Water Surface profile");
		scrolledComposite.setContent(chart);
		scrolledComposite.setMinSize(chart.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	}

	/**
	 * 
	 */
	public void updateChart() {
		
		ProgressiveWave wave = (ProgressiveWave) application.getContext().get("wave");
		
		System.out.println("L = " + wave.getL());
		
		List<Etta> ettas = wave.computeEttas(0, wave.getL()*2, 0, 100);
		for (Etta etta : ettas) {
			System.out.println("x = " + etta.getX()+", z = "+ etta.getZ());
		}
		
		double[] xs = new double[ettas.size()];
		double[] zs = new double[ettas.size()];
		for (int i = 0; i < ettas.size(); i++) {
			Etta e = ettas.get(i);
			xs[i]=e.getX();
			zs[i]=e.getZ() + wave.getD();
		}
		
		ISeriesSet seriesSet = chart.getSeriesSet();
		ILineSeries series = (ILineSeries) seriesSet.createSeries(SeriesType.LINE, "Water Surface");
		series.enableArea(true);
		series.setYSeries(zs);
		series.setXSeries(xs);
		IAxisSet axisSet = chart.getAxisSet();
		axisSet.getXAxis(0).getTitle().setText("x");
		axisSet.getYAxis(0).setRange(new Range(-(wave.getH()*2)+ wave.getD(), wave.getH()*2+wave.getD()));
		axisSet.getXAxis(0).setRange(new Range(ettas.get(0).getX(), ettas.get(ettas.size()-1).getX()));
		axisSet.getYAxis(0).getTitle().setText("z (above sea bottom)");
		series.setSymbolType(PlotSymbolType.NONE);
//		axisSet.adjustRange();
		chart.redraw();
	}
	
	
	
	
}