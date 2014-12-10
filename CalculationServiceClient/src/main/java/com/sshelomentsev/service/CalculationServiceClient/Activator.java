package com.sshelomentsev.service.CalculationServiceClient;

import com.sshelomentsev.service.CalculationService.CalculationService;
import com.sshelomentsev.service.SimpleLogger.Logger;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;


/**
 * Created by sshelomentsev on 08/12/14.
 */
public class Activator implements BundleActivator {
    CalculationService calcService;
    Logger logger;
    private BundleContext context;

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        context = bundleContext;

        ServiceReference logRef = context.getServiceReference(Logger.class.getName());
        logger = (Logger) context.getService(logRef);

        ServiceReference calcRef = context.getServiceReference(CalculationService.class.getName());
        calcService = (CalculationService) context.getService(calcRef);
        System.out.println("Client");
        logger.info("Client started");
        //logger.info(Double.toString(calcService.mult(10, 20)));

    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("Client stopped");
    }
}
