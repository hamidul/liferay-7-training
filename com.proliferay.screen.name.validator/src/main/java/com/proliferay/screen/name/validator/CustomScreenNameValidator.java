package com.proliferay.screen.name.validator;

import java.util.Locale;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.security.auth.ScreenNameValidator;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.proliferay.config.ReservedWordsConfiguration;

/**
 * @author Hamidul Islam
 */
@Component(
	immediate = true,
	configurationPid = "com.proliferay.config.ReservedWordsConfiguration",
	property = {
			"service.ranking:Integer=100"
	},
	service = ScreenNameValidator.class
)
public class CustomScreenNameValidator implements ScreenNameValidator {

	 /**
     * 
     * Client Side Validation
     * 
     * Provides the JavaScript validations for the UI 
     */
    @Override
    public String getAUIValidatorJS() {
        _log.info("######Calling getAUIValidatorJS()####");
        StringBuilder javascript = new StringBuilder();
 
        try {
            Company company = _companyLocalService.getCompanyByWebId(
                PropsUtil.get(PropsKeys.COMPANY_DEFAULT_WEB_ID));
 
            long companyId = company.getCompanyId();
            _log.info("########companyId###########"+companyId);
 
            String[] reservedWords = getReservedWords(companyId);
 
            javascript.append("function(val) { return !(");
 
            for (int i = 0; i < reservedWords.length; i++) {
                javascript.append(
                    "val.indexOf(\"" + reservedWords[i] + "\") !== -1");
 
                if ((reservedWords.length > 1) &&
                    (i < (reservedWords.length - 1))) {
 
                    javascript.append(" || ");
                }
            }
 
            javascript.append(")}");
        }
        catch (PortalException portalException) { 
            _log.error(portalException);
        }catch (Exception e) {
            _log.error(e);
        }
        
        return javascript.toString();
    }

    /**
     * This method display the actual error message in the UI
     * This can be localized 
     * Use Resource Bundle to display the error message. However this is optional 
     */
    @Override
    public String getDescription(Locale locale) {
        _log.info("######Calling getDescription()####");
        
        ResourceBundle resourceBundle = ResourceBundleUtil.getBundle("content.Language", locale, getClass());
        
        //Look the key error.description in properties file
        String description = ResourceBundleUtil.getString(resourceBundle, "error.description");
        
        return  description;
    }

    /**
     * Server Side Validations 
     * 
     * Validate the screen name provided by the user against the reserved words 
     * which are set in the control panel 
     * 
     * If the screen name entered contains reserved words return false, otherwise return true
     */
    @Override
    public boolean validate(long companyId, String screenName) {
        _log.info("######Calling validate()####");
        String[] reservedWords = getReservedWords(companyId);
        
        String lowerCaseScreenName = StringUtil.toLowerCase(screenName); 
        for (String word : reservedWords) {
            if (lowerCaseScreenName.contains(StringUtil.toLowerCase(word))) {
                return false;
            }
        }
 
        return true;
    }
	
	private String[] getReservedWords(long companyId) {
        ReservedWordsConfiguration reservedWordsConfiguration = null; 
        try {
            //Retrieve the compnay specific Configuration 
            reservedWordsConfiguration = _configurationProvider.getCompanyConfiguration(ReservedWordsConfiguration.class, companyId);
        } catch (ConfigurationException e) {
            _log.error(e);
        }catch (Exception e) {
            _log.error(e);
        }
 
        if (reservedWordsConfiguration != null) {
            return reservedWordsConfiguration.reservedWords();
        }
 
        return new String[0];
    }

	private static Log _log = LogFactoryUtil.getLog(CustomScreenNameValidator.class);
	 
    @Reference
    private volatile CompanyLocalService _companyLocalService;
 
    /**
     * _configurationProvider will be auto injected by the framework 
     * 
     * Later on from _configurationProvider we can retrieve DemoScreenNameConfiguration instance 
     */
    @Reference
    private volatile ConfigurationProvider _configurationProvider;

}