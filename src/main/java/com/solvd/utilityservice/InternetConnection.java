package com.solvd.utilityservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InternetConnection implements AutoCloseable {

    public static final Logger LOGGER = LogManager.getLogger(InternetConnection.class);

    public void connectTheInternet() {
        LOGGER.debug("The Internet was connected");
    }

    @Override
    public void close() {
        LOGGER.debug("Disconnection");
    }
}
