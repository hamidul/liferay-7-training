package com.prolifreay.login.action;

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
		"key=login.events.pre" 
	},
	service = LifecycleAction.class
)
public class LoginPreAction implements LifecycleAction {

	@Override
	public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {
		_log.info("############## Login Pre Action Invoked ##################"); 
		
	}

	private static final Log _log = LogFactoryUtil.getLog(LoginPreAction.class);

}