package com.iterium.serverless;

import com.iterium.serverless.data.DatabaseUtil;
import org.apache.log4j.Logger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class Monitor implements RequestHandler<Object, String> {
	private static final Logger logger = Logger.getLogger(Monitor.class);

	@Override
	public String handleRequest(Object input, Context context) {
		logger.info("Starting lambda function");
		DatabaseUtil dbUtil = new DatabaseUtil();

		return "ok";
	}
}
