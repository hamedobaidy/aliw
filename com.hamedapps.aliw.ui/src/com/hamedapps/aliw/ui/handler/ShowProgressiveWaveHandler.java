 
package com.hamedapps.aliw.ui.handler;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;

public class ShowProgressiveWaveHandler {
	@Execute
	public void execute(MApplication application, EPartService partService, EModelService modelService) {
		MPerspective progressive = (MPerspective) modelService.find("com.hamedapps.aliw.ui.perspective.progressivewave", application);
		partService.switchPerspective(progressive);
	}
		
}