package com.proliferay.portlet;

import com.proliferay.constants.LifeCycleDemoPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.util.Map;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;

/**
 * @author Hamidul Islam
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Pro Liferay",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Lifecycle Demo",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + LifeCycleDemoPortletKeys.LifeCycleDemo,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class,
	configurationPid="SomeConfiguration",
	configurationPolicy= ConfigurationPolicy.OPTIONAL
)
public class LifeCycleDemoPortlet extends MVCPortlet {
	
	@Activate
	void activate(Map<Object, Object> properties){
		_log.info("################ Calling Activate Method ######################");
		printProperties(properties);
		
	}
	
	@Deactivate
	void deactivate(Map<Object, Object> properties){
		_log.info("################ Calling Deactivate Method ######################");
		printProperties(properties);
		
	}
	
	@Modified
	void modified(Map<Object, Object> properties){
		_log.info("################ Calling Modified Method ######################");
		printProperties(properties);
		
	}
	
	private void printProperties(Map<Object, Object> properties){
		for(Map.Entry<Object, Object> entry : properties.entrySet()){
			_log.info("Key : "+entry.getKey() + " Value : "+entry.getValue());
		}
	}
	private static final Log _log = LogFactoryUtil.getLog(LifeCycleDemoPortlet.class);
}