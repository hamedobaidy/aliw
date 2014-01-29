 
package com.hamedapps.aliw.ui.part;

import javax.inject.Inject;
import javax.annotation.PostConstruct;
import org.eclipse.swt.widgets.Composite;
import javax.annotation.PreDestroy;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.custom.ScrolledComposite;

public class ProgressiveDataPart {
	private Text textT;
	private Text textH;
	private Text textD;
	private Text textL;
	private Text textSigma;
	private Text textK;
	private Text textComents;
	@Inject
	public ProgressiveDataPart() {
		//TODO Your code here
	}
	
	@PostConstruct
	public void postConstruct(Composite parent) {
		parent.setLayout(new GridLayout(2, false));
		
		Label lblWavePeriod = new Label(parent, SWT.NONE);
		lblWavePeriod.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblWavePeriod.setText("Wave Period (T) : ");
		
		textT = new Text(parent, SWT.BORDER);
		textT.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblWaveHeighth = new Label(parent, SWT.NONE);
		lblWaveHeighth.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblWaveHeighth.setText("Wave Height (H) : ");
		
		textH = new Text(parent, SWT.BORDER);
		textH.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblWaterDepthh = new Label(parent, SWT.NONE);
		lblWaterDepthh.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblWaterDepthh.setText("Water Depth (d) : ");
		
		textD = new Text(parent, SWT.BORDER);
		textD.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button btnComputeWaveLength = new Button(parent, SWT.NONE);
		btnComputeWaveLength.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		btnComputeWaveLength.setText("Compute Wave Length, k and sigma");
		
		Label lblWaveLengthl = new Label(parent, SWT.NONE);
		lblWaveLengthl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblWaveLengthl.setText("Wave Length (L) : ");
		
		textL = new Text(parent, SWT.BORDER);
		textL.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblWaveAngularFrequency = new Label(parent, SWT.NONE);
		lblWaveAngularFrequency.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblWaveAngularFrequency.setText("Wave Angular Frequency : ");
		
		textSigma = new Text(parent, SWT.BORDER);
		textSigma.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblWaveNumberk = new Label(parent, SWT.NONE);
		lblWaveNumberk.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblWaveNumberk.setText("Wave Number (k) : ");
		
		textK = new Text(parent, SWT.BORDER);
		textK.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		textComents = new Text(scrolledComposite, SWT.BORDER | SWT.WRAP | SWT.MULTI);
		scrolledComposite.setContent(textComents);
		scrolledComposite.setMinSize(textComents.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		//TODO Your code here
	}
	
	
	@PreDestroy
	public void preDestroy() {
		//TODO Your code here
	}
	
	
	@Focus
	public void onFocus() {
		//TODO Your code here
	}
	
	
	@Persist
	public void save() {
		//TODO Your code here
	}
	
}