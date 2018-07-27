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
        String query = System.getProperty(QUERY);
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(query);
            if(rs.next()) {
                int total = rs.getInt("QUANITDADE");
                return total;
            } else {
                return 0;
            }
        } catch (SQLException exception) {
            logger.error(exception.getMessage());
        }
        return 0;
    }
}
