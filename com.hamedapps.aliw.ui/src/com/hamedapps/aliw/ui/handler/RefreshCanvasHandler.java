 
package com.hamedapps.aliw.ui.handler;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.workbench.modeling.EPartService;

import com.hamedapps.aliw.model.ProgressiveWave;
import com.hamedapps.aliw.ui.part.EtaDataPart;
import com.hamedapps.aliw.ui.part.ProgressiveCanvasPart;
import com.hamedapps.aliw.ui.part.ProgressiveDataPart;

public class RefreshCanvasHandler {
	@Execute
	public void execute(EPartService partService, MApplication application) {
		
		ProgressiveDataPart dataPart = (ProgressiveDataPart) partService.findPart("com.hamedapps.aliw.ui.part.data").getObject();
		dataPart.updateWaveProperties();
		
		ProgressiveWave wave = (ProgressiveWave) application.getContext().get("wave");
		System.out.println(wave);
		
		ProgressiveCanvasPart chartPart = (ProgressiveCanvasPart) partService.findPart("com.hamedapps.aliw.ui.part.progressivecanvas").getObject();
		chartPart.updateChart();
		
		EtaDataPart etaDataPart = (EtaDataPart)partService.findPart("com.hamedapps.aliw.ui.part.eta").getObject();
		etaDataPart.updateTableViewer();
	}
		
}