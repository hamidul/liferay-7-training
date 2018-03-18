package com.proliferay;

import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.ManagedService;

import com.proliferay.service.MyManagedService;

/**
 * @author Hamidul Islam
 */
public class Activator implements BundleActivator {

	private ServiceRegistration<?> serviceRegistration;
	
	@Override
	public void start(BundleContext bundleContext) throws Exception {
		MyManagedService managedService = new MyManagedService();
		Dictionary<String, String> properties = new Hashtable<String, String>();
		properties.put(Constants.SERVICE_PID, "myManagedService");
		
		String[] classes = new String[]{MyManagedService.class.getName(),ManagedService.class.getName()}; 
		serviceRegistration = bundleContext.registerService(classes, managedService, properties); 
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		
		serviceRegistration.unregister();
	}

}