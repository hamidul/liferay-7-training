package com.proliferay;



import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.proliferay.api.HelloApi;
import com.proliferay.impl.HelloApiImpl;

/**
 * @author Hamidul Islam
 */
public class SampleActivator implements BundleActivator {
	
	@Override
	public void start(BundleContext bundleContext) throws Exception {
		
		System.out.println("################# Registering Service #######################");
		
		bundleContext.registerService(HelloApi.class,new HelloApiImpl(),null);
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
	}

}