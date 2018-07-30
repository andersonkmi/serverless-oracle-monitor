package com.iterium.serverless.data;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.iterium.serverless.utils.AWSLambdaEnvVars.QUERY;

public class OracleMonitor {
    private static final Logger logger = Logger.getLogger(OracleMonitor.class);

    public int getTotalRecords(Connection connection) {
        logger.info("calling get total records");
        String query = System.getenv(QUERY);
        try (Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            ResultSet rs = statement.executeQuery(query);
            rs.last();
            int total = rs.getInt(1);
            logger.info("Total: " + total);
            return total;
        } catch (SQLException exception) {
            logger.error("Exception: " + exception.getMessage());
        }
        return 0;
    }
}
