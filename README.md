# Serverless Oracle monitoring

## Introduction
This project is responsible for implementing a simple Oracle
monitoring system using AWS Lambda and Serverless framework.

## Prerequisites

In order to run this project, the following requirements are
necessary:

- NodeJS 8.10
- Serverless framework
- Gradle 4.9
- Java SDK 1.8.0
- AWS access and secret keys locally configured
- Oracle JDBC driver (ojdbc7.jar) inside libs folder. Create such 
folder if required.

## How-tos

In this section you will find instructions on how to build and
deploy this lambda function.

### Build

In order to build the project, run the following command:
```
$ gradle clean build
```

### Deploy / Undeploy

In order to deploy the project, run the following command:
```
$ serverless deploy
```

In order to remove the lambda function from your AWS environment,
run the following command:
```
$ serverless remove
```
