package com.sshelomentsev.service.SimpleLogger;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * Created by sshelomentsev on 09/12/14.
 */
public class Activator implements BundleActivator {

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        Logger logger = new LoggerImpl();
        bundleContext.registerService(Logger.class.getName(), logger, null);
        System.out.println("Logger started");
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("Logger stopped");
    }
}
