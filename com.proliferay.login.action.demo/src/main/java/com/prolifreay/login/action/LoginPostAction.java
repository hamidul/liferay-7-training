package com.prolifreay.login.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;


/**
 * @author Hamidul Islam
 */
@Component(
	immediate = true,
	property = {
		"key=login.events.post" 
	},
	service = LifecycleAction.class
)
public class LoginPostAction implements LifecycleAction {

	@Override
	public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {
		_log.info("############## Login Post Action Invoked ##################"); 
		
		HttpServletResponse httpResponse = lifecycleEvent.getResponse();
		
		try {
			_log.info("############# Redirecting to Test Page ############"); 
			httpResponse.sendRedirect("/c/portal/login?redirect=%2Fweb%2Fguest%2Ftest");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	private static final Log _log = LogFactoryUtil.getLog(LoginPostAction.class);

}