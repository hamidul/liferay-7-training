package com.proliferay.service.wrapper.demo;

import java.util.Map;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.UserLocalServiceWrapper;

/**
 * @author Hamidul Islam
 */
@Component(
	immediate = true,
	property = {
	},
	service = ServiceWrapper.class
)
public class UserServiceWrapperDemo extends UserLocalServiceWrapper {

	public UserServiceWrapperDemo() {
		super(null);
	}
	
	
	
	
	
	@Override
	public int authenticateByEmailAddress(long companyId, String emailAddress, String password,
			Map<String, String[]> headerMap, Map<String, String[]> parameterMap, Map<String, Object> resultsMap)
			throws PortalException {


		_log.info("#### Authenticating by Email ######" + emailAddress); 
		
		return super.authenticateByEmailAddress(companyId, emailAddress, password, headerMap, parameterMap, resultsMap);
	}





	private static final Log _log = LogFactoryUtil.getLog(UserServiceWrapperDemo.class);

}