package com.sshelomentsev.service.test;

import com.sshelomentsev.service.CalculationService.CalculationService;
import com.sshelomentsev.service.SimpleLogger.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.CoreOptions;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.Configuration;
import org.ops4j.pax.exam.junit.JUnit4TestRunner;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import javax.inject.Inject;

/**
 * Created by sshelomentsev on 09/12/14.
 */
@RunWith(JUnit4TestRunner.class)
public class ServiceTestCase {

    @Inject
    private BundleContext context;

    @Configuration
    public Option[] config() {

        return CoreOptions.options(
                CoreOptions.mavenBundle("com.sshelomentsev.service", "SimpleLogger"),
                CoreOptions.mavenBundle("com.sshelomentsev.service", "CalculationService"),
                CoreOptions.mavenBundle("com.sshelomentsev.service", "CalculationServiceClient"),
                CoreOptions.junitBundles());
    }

    @Test
    public void getCalcService() {
        ServiceReference ref = context.getServiceReference(CalculationService.class.getName());
        CalculationService service = (CalculationService) context.getService(ref);
        Assert.assertNotNull(service);
        try {
            Assert.assertEquals(service.mult(20, 15), 300.0, 0.0);
        } finally {
            context.ungetService(ref);
        }

    }

    @Test
    public void getLogger() {
        ServiceReference loggerRef = context.getServiceReference(Logger.class.getName());
        Logger logger = (Logger) context.getService(loggerRef);
        Assert.assertNotNull(logger);

        ServiceReference calcRef = context.getServiceReference(CalculationService.class.getName());
        CalculationService calcService = (CalculationService) context.getService(calcRef);
        Assert.assertNotNull(calcService);

        context.ungetService(calcRef);
        context.ungetService(loggerRef);
    }
}
