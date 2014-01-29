 
package com.hamedapps.aliw.ui.handler;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.modeling.EPartService;

import com.hamedapps.aliw.ui.part.ProgressiveCanvasPart;

public class RefreshCanvasHandler {
	@Execute
	public void execute(EPartService partService) {
		ProgressiveCanvasPart part = (ProgressiveCanvasPart) partService.findPart("com.hamedapps.aliw.ui.part.progressivecanvas").getObject();
		part.updateChart();
	}
		
}