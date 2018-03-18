package com.proliferay.service;

import java.util.Dictionary;

import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedService;

public class MyManagedService implements ManagedService{

	@Override
	public void updated(Dictionary<String, ?> properties) throws ConfigurationException {
		if(properties != null){
			System.out.println("port = "+properties.get("port"));  
		}
		
	}

}
