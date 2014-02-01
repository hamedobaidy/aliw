 
package com.hamedapps.aliw.ui.part;

import javax.inject.Inject;
import javax.annotation.PostConstruct;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ColumnPixelData;

import com.hamedapps.aliw.model.Etta;
import com.hamedapps.aliw.model.ProgressiveWave;

	

public class EtaDataPart {
	private Table table;
	
	@Inject
	private MApplication application;

	private TableViewer tableViewer;
	
	@Inject
	public EtaDataPart() {
		//TODO Your code here
	}
	
	@PostConstruct
	public void postConstruct(Composite parent) {
		parent.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		Composite composite = new Composite(scrolledComposite, SWT.NONE);
		TableColumnLayout tcl_composite = new TableColumnLayout();
		composite.setLayout(tcl_composite);
		
		tableViewer = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnX = tableViewerColumn.getColumn();
		tcl_composite.setColumnData(tblclmnX, new ColumnPixelData(150, true, true));
		tblclmnX.setText("x");
		tableViewerColumn.setLabelProvider(new ColumnLabelProvider() {
			/* (non-Javadoc)
			 * @see org.eclipse.jface.viewers.ColumnLabelProvider#getText(java.lang.Object)
			 */
			@Override
			public String getText(Object element) {
				Etta e = (Etta)element;
				return Double.toString(e.getX());
			}
		});
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnWaterSurfaceLevel = tableViewerColumn_1.getColumn();
		tcl_composite.setColumnData(tblclmnWaterSurfaceLevel, new ColumnPixelData(179, true, true));
		tblclmnWaterSurfaceLevel.setText("Water Surface Level");
		tableViewerColumn_1.setLabelProvider(new ColumnLabelProvider() {
			/* (non-Javadoc)
			 * @see org.eclipse.jface.viewers.ColumnLabelProvider#getText(java.lang.Object)
			 */
			@Override
			public String getText(Object element) {
				Etta e = (Etta) element;
				return Double.toString(e.getZ());
			}
		});
		
		scrolledComposite.setContent(composite);
		scrolledComposite.setMinSize(table.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		tableViewer.setContentProvider(new ArrayContentProvider());
		
		updateTableViewer();
	}

	/**
	 * 
	 */
	public void updateTableViewer() {
		ProgressiveWave wave = (ProgressiveWave) application.getContext().get("wave");
		tableViewer.setInput(wave.computeEttas(0, wave.getL()*2, 0, 100));
	}	
}