package com.proliferay.panel;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;
import com.proliferay.constants.PanelAppDemoPortletKeys;

@Component(immediate = true,
	property = {
			"panel.app.order:Integer=500",
			"panel.category.key="+PanelCategoryKeys.USER_MY_ACCOUNT
	},
  service = PanelApp.class
)

public class MyPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {

		return PanelAppDemoPortletKeys.PanelAppDemo;
	}

	@Override
	@Reference(
			target ="(javax.portlet.name="+PanelAppDemoPortletKeys.PanelAppDemo+")",
			unbind = "-"
			)
	public void setPortlet(Portlet portlet) {
	
		super.setPortlet(portlet);
	}

}
