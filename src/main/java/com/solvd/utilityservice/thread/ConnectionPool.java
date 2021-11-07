package com.solvd.utilityservice.thread;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ConnectionPool {

    public static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);

    private static volatile ConnectionPool instance;
    private static volatile List<Connection> connections;
    private static Integer maxConnectionNumber;

    private ConnectionPool(Integer maxConnectionNumber) {
    }

    public static ConnectionPool getInstance(Integer maxConnectionNumber) {
        if (instance == null) {
            synchronized (ConnectionPool.class) {
                if (instance == null) {
                    instance = new ConnectionPool(maxConnectionNumber);
                }
                connections = new ArrayList<>();
                IntStream.range(0, maxConnectionNumber).forEach(i ->
                        connections.add(new Connection()));
                return instance;
            }
        }
        return instance;
    }

    public Connection getConnection() {
        synchronized (this.connections) {
            Connection connection = connections
                    .remove(connections.size() - 1);
            return connection;
        }
    }

    public synchronized void releaseConnection(Connection connection) {
        connections.add(connection);
    }
}
