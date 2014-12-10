package com.sshelomentsev.service.CalculationService;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;


/**
 * Created by sshelomentsev on 08/12/14.
 */
public class Activator implements BundleActivator {

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        CalculationService service = new CalculationServiceImpl();
        bundleContext.registerService(CalculationService.class.getName(), service, null);
        System.out.println("Calculation service was registered");
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("Calculation service was unregistered");
    }
}
