package com.proliferay.declaration;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;
import com.proliferay.config.ReservedWordsConfiguration;

@Component
public class BeanDeclaration implements ConfigurationBeanDeclaration{

	@Override
	public Class<?> getConfigurationBeanClass() {
		
		return ReservedWordsConfiguration.class;
	}

}
