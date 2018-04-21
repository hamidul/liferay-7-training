package com.proliferay.config;

import java.util.Hashtable;
import java.util.Map;

import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true, 
		service = SomeConfiguration.class
)
public class SomeConfiguration {

	@Activate
	void activate(Map<Object, Object> properties) {
		try {

			Configuration config = configurationAdmin.getConfiguration("SomeConfiguration");
			
			Hashtable<String, Object> props = new Hashtable<>();
			props.put("name", "John");
			props.put("age", "30");
			props.put("address", "LA");
			
			config.update(props);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Reference
	private ConfigurationAdmin configurationAdmin;
}
