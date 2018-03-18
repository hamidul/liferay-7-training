package com.proliferay.sample.activator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * @author Hamidul Islam
 */
public class SampleActivator implements BundleActivator {

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("################ STARTING ##################");
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("################ STOPPING ##################");
	}

}