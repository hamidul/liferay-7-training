package com.proliferay.portlet;

import com.proliferay.configuration.DemoConfiguration;
import com.proliferay.constants.ConfigurationDemoPortletKeys;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

/**
 * @author liferay
 */
@Component(
	immediate = true,
	configurationPid = "com.proliferay.configuration.DemoConfiguration",
	property = {
		"com.liferay.portlet.display-category=Pro Liferay",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Configuration Demo Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ConfigurationDemoPortletKeys.ConfigurationDemo,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ConfigurationDemoPortlet extends MVCPortlet {
	
	@Override
    public void doView(
            RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {
        
        /**
         renderRequest.setAttribute(
                 DemoConfiguration.class.getName(),
                 _demoConfiguration);
        */

        /**
         * Configuration can be directly set in the control panel of liferay 
         * We can access those here 
         */


        _log.info("#########City##########"+_demoConfiguration.city()); 
        _log.info("#########Unit##########"+_demoConfiguration.temperatureUnit());
        super.doView(renderRequest, renderResponse);
    }
	
	
	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		_log.info("#####Calling activate() method######");

		_demoConfiguration = ConfigurableUtil.createConfigurable(DemoConfiguration.class, properties);

	}
	
	private static final Log _log = LogFactoryUtil.getLog(ConfigurationDemoPortlet.class);

	private volatile DemoConfiguration _demoConfiguration; 
}