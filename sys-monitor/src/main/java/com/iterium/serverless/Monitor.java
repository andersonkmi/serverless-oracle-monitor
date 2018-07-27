package com.iterium.serverless;

import com.iterium.serverless.data.DatabaseUtil;
import com.iterium.serverless.data.OracleMonitor;
import org.apache.log4j.Logger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.sql.Connection;

public class Monitor implements RequestHandler<Object, String> {
	private static final Logger logger = Logger.getLogger(Monitor.class);

	@Override
	public String handleRequest(Object input, Context context) {
		logger.info("Starting lambda function");
		DatabaseUtil dbUtil = new DatabaseUtil();
		Connection connection = dbUtil.getConnection();
		if(connection != null) {
			OracleMonitor monitor = new OracleMonitor();
			int res = monitor.getTotalRecords(connection);
			logger.info("Total: " + res);
			dbUtil.release();
		}
		return "ok";
	}
}
