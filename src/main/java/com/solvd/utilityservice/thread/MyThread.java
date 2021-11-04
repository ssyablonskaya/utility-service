package com.solvd.utilityservice.thread;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyThread extends Thread {

    public static final Logger LOGGER = LogManager.getLogger(Thread.class);

    private ConnectionPool connectionPool;

    public MyThread(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public void run() {
        Connection connection = connectionPool.getConnection();
        connection.createMethod();
        connection.readMethod();
        connection.updateMethod();
        connection.deleteMethod();
        connectionPool.releaseConnection(connection);
    }
}
