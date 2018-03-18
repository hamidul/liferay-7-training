package com.proliferay;

import org.osgi.service.component.annotations.Component;

import com.proliferay.api.HelloApi;

/**
 * @author liferay
 */
@Component(
	immediate = true,
	property = {
		
	},
	service = HelloApi.class
)
public class SampleComponent implements HelloApi {

	@Override
	public String sayHello(String name) {
		
		return "Hello " + name+ " from sample component";
	}

}