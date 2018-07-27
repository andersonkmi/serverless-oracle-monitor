package com.iterium.serverless.data;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.iterium.serverless.utils.AWSLambdaEnvVars.CONNECTION_STRING;

public class DatabaseUtil {
    private static final Logger logger = Logger.getLogger(DatabaseUtil.class);
    private Connection connection;

    public void connect() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(System.getProperty(CONNECTION_STRING));
        } catch (SQLException | ClassNotFoundException exception) {
            logger.error(exception.getMessage());
        }

    }

    public Connection getConnection() {
        return connection;
    }

    public void release() {
        try {
            if(connection != null) {
                connection.close();
            }
        } catch (SQLException exception) {
            logger.error(exception.getMessage());
        }
    }
}
