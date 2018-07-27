package com.iterium.serverless.utils;

import org.apache.log4j.Logger;

import static com.iterium.serverless.utils.AWSLambdaEnvVars.*;

public class OrderAccVerifier {
    public static final Logger logger = Logger.getLogger(OrderAccVerifier.class);

    public void verifyQuantity(int quantity) {
        logger.info("Verifying quantity");

        Integer warningLevel = Integer.parseInt(System.getenv(WARNING_THRESHOLD));
        Integer criticalLevel = Integer.parseInt(System.getenv(CRITICAL_THRESHOLD));
        String warningMessage = System.getenv(WARNING_MESSAGE);
        String criticalMessage = System.getenv(CRITICAL_MESSAGE);

        if(quantity >= warningLevel) {
            SNSPublisher sns = new SNSPublisher();
            sns.sendMessage(warningMessage + " " + quantity);
        } else if(quantity >= criticalLevel) {
            SNSPublisher sns = new SNSPublisher();
            sns.sendMessage(criticalMessage + " " + quantity);
        } else {
            logger.info("Quantity levels under normal condition");
        }
    }
}
