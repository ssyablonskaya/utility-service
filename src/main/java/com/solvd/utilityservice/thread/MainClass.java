package com.solvd.utilityservice.thread;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainClass {

    public static final Logger LOGGER = LogManager.getLogger(MainClass.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ConnectionPool connectionPool = ConnectionPool.getInstance(5);
        IntStream.range(0, 100)
                .boxed()
                .forEach(index -> {
                    Thread thread = new MyThread(connectionPool);
                    thread.start();
                    try {
                        Thread.sleep(555);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });

        // executor
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<CompletableFuture<Void>> futuresList = IntStream.range(0, 100).boxed()
                .map(index -> {
                    CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(
                            () -> new Connection(), executorService)
                    .thenAccept(connection -> connection.createMethod());
                    return completableFuture;
                })
        .collect(Collectors.toList());

        CompletableFuture<Void> all = CompletableFuture.allOf(futuresList.toArray(new CompletableFuture[futuresList.size()]));
        all.join();
        executorService.shutdown();
        LOGGER.info("Shout down");


    }
}