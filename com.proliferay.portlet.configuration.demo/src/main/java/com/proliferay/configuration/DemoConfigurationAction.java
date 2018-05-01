package com.proliferay.configuration;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;

@Component(
        configurationPid = "com.proliferay.configuration.DemoConfiguration",
        configurationPolicy = ConfigurationPolicy.OPTIONAL, immediate = true,
        property = {
            "javax.portlet.name=ConfigurationDemo"
        },
        service = ConfigurationAction.class
    )
public class DemoConfigurationAction extends DefaultConfigurationAction {


	@Override
	public void include(PortletConfig portletConfig, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute(DemoConfiguration.class.getName(), _demoConfiguration);
		super.include(portletConfig, request, response);
	}
	
	@Override
    public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
            throws Exception {

        

        String city = ParamUtil.getString(actionRequest, "city");
        String unit = ParamUtil.getString(actionRequest, "unit");  
        

        
        setPreference(actionRequest, "city", city);
        setPreference(actionRequest, "unit", unit);
    

        super.processAction(portletConfig, actionRequest, actionResponse);
    }
	
	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		_log.info("#####Calling activate() method######");
		
		_demoConfiguration = ConfigurableUtil.createConfigurable(DemoConfiguration.class, properties);
	}

	
	
	private static final Log _log = LogFactoryUtil.getLog(DemoConfigurationAction.class);

	 private volatile DemoConfiguration _demoConfiguration; 
}
