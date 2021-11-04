package com.solvd.utilityservice.thread;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.IntStream;

public class MainClass {

    public static final Logger LOGGER = LogManager.getLogger(MainClass.class);

    public static void main(String[] args) {
        ConnectionPool connectionPool = ConnectionPool.getInstance(5);

        IntStream.range(0, 10)
                .boxed()
                .forEach(index -> {
                    Thread thread = new MyThread(connectionPool);
                    thread.start();
                    try {
                        Thread.sleep(345);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
    }
}