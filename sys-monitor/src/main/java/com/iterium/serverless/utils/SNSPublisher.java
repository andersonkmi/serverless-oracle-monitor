package com.iterium.serverless.utils;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;

import static com.iterium.serverless.utils.AWSLambdaEnvVars.SNS_TOPIC;

public class SNSPublisher {

    public void sendMessage(String message) {
        String topic = System.getenv(SNS_TOPIC);
        AmazonSNS sns = AmazonSNSClientBuilder.standard().build();
        sns.publish(topic, message);
    }
}
