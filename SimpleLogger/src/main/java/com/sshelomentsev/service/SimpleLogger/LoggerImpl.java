package com.sshelomentsev.service.SimpleLogger;



/**
 * Created by sshelomentsev on 09/12/14.
 */
public class LoggerImpl implements Logger {
    @Override
    public void error(String message) {
        //DateTime dt = new DateTime();
        //System.out.println("ERROR [" + dt.getMillis() + "] " + message);
        System.out.println("ERROR " + message);
    }

    @Override
    public void warn(String message) {
        //DateTime dt = new DateTime();
        //System.out.println("WARN [" + dt.getMillis() + "] " + message);
        System.out.println("WARN " + message);
    }

    @Override
    public void info(String message) {
        //DateTime dt = new DateTime();
        //System.out.println("INFO [" + Long.toString(dt.getMillis()) + "] " + message);
        System.out.println("INFO " + message);
    }
}
