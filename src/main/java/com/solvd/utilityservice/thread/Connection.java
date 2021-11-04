package com.solvd.utilityservice.thread;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Connection {

    public static final Logger LOGGER = LogManager.getLogger(Connection.class);

    public void createMethod() {
        LOGGER.info("I've created this method");
        try {
            Thread.sleep(1234);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void readMethod() {
        LOGGER.info("I've read this method");
        try {
            Thread.sleep(1234);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void updateMethod() {
        LOGGER.info("I've updated this method");
        try {
            Thread.sleep(1234);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void deleteMethod() {
        LOGGER.info("I've deleted this method");
        try {
            Thread.sleep(1234);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
