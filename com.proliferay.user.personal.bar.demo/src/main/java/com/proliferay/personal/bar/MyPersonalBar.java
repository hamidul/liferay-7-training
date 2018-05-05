package com.proliferay.personal.bar;

import org.osgi.service.component.annotations.Component;

import com.liferay.admin.kernel.util.PortalUserPersonalBarApplicationType;
import com.liferay.portal.kernel.portlet.BasePortletProvider;
import com.liferay.portal.kernel.portlet.ViewPortletProvider;

@Component(
		immediate = true,
		property={
				"model.class.name=" + PortalUserPersonalBarApplicationType.UserPersonalBar.CLASS_NAME,
				"service.ranking:Integer=10"
				
		},
		service = ViewPortletProvider.class
)

public class MyPersonalBar extends BasePortletProvider implements ViewPortletProvider{
	
	private final String PORTLET_NAME = "CustomPersonalBar";
	
	@Override
	public String getPortletName() {
		
		return PORTLET_NAME;
	}

}
