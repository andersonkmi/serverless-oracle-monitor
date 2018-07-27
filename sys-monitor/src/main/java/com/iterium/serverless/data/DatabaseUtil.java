package com.iterium.serverless.data;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.iterium.serverless.utils.AWSLambdaEnvVars.CONNECTION_STRING;
import static com.iterium.serverless.utils.AWSLambdaEnvVars.PASSWORD;
import static com.iterium.serverless.utils.AWSLambdaEnvVars.USER;

public class DatabaseUtil {
    private static final Logger logger = Logger.getLogger(DatabaseUtil.class);
    private Connection connection;

    public Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String connString = System.getenv(CONNECTION_STRING);
            String user = System.getenv(USER);
            String pwd = System.getenv(PASSWORD);
            connection = DriverManager.getConnection(connString, user, pwd);
            return connection;
        } catch (SQLException | ClassNotFoundException exception) {
            logger.error(exception.getMessage());
        }
        return null;
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
