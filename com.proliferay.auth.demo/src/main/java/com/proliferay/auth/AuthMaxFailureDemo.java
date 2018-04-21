package com.proliferay.auth;

import java.util.Map;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auth.AuthException;
import com.liferay.portal.kernel.security.auth.AuthFailure;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

/**
 * @author Hamidul Islam
 */
@Component(
	immediate = true,
	property = {
	     "key=auth.max.failures"
	},
	service = AuthFailure.class
)
public class AuthMaxFailureDemo implements AuthFailure {

	@Override
	public void onFailureByEmailAddress(long companyId, String emailAddress, Map<String, String[]> headerMap,
			Map<String, String[]> parameterMap) throws AuthException {


		
		try{
			
			User user = UserLocalServiceUtil.getUserByEmailAddress(companyId, emailAddress);
			
			int failures = user.getFailedLoginAttempts();
			
			_log.info("Login Failed : Email Id :"+emailAddress);
			_log.info("Login Attempts : "+failures); 
		}catch (Exception e) {
			_log.error("Exceptions while log in ",e);
		}
		
	}

	@Override
	public void onFailureByScreenName(long companyId, String screenName, Map<String, String[]> headerMap,
			Map<String, String[]> parameterMap) throws AuthException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFailureByUserId(long companyId, long userId, Map<String, String[]> headerMap,
			Map<String, String[]> parameterMap) throws AuthException {
		// TODO Auto-generated method stub
		
	}

	private static final Log _log = LogFactoryUtil.getLog(AuthMaxFailureDemo.class);

}