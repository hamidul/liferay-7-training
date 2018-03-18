package com.proliferay;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.proliferay.api.HelloApi;

/**
 * @author Hamidul Islam
 */
public class RetrieveServiceActivator implements BundleActivator {

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		
		ServiceReference<HelloApi> serviceReference = bundleContext.getServiceReference(HelloApi.class);
		
		HelloApi helloApi = bundleContext.getService(serviceReference);
		
		String message = helloApi.sayHello("Hamidul");
		
		System.out.println("############## Message #############"+message);
		
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
	}

}