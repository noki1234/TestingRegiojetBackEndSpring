# TestingRegiojetBackEndSpring

This is project for FrontEnd testing Using: IntelliJ, language level: Java 11, Spring Boot + added Rest Assured

Structure:

In main/java are: packages api, model, service and TestingZoomRestSpringApplication.java, Utils.java
- package api - contains two Controller classes (one is from Fake 'environment' - using fake methods with fake data, one is standard obtaining real data)
- package model - contains 2 models: TravelResult which represents general search response/result coming from server, Route which represent single route element
- package service - contains from Services (fake + standard) that are sending get requests over webClient to web/server
- TestingZoomRestSpringApplication.java
- Utils.java - contains some useful methods

In test/java are: tests TestingEvaluationFunctionsForMockedRoutes.java and TestingZoomRestSpringApplicationTests.java:
- TestingEvaluationFunctionsForMockedRoutes.java - contains tests for testing correct evaluation of (fake) methods that are similar to real one, which is used for obtaining/filtering (fake) data according to our specifications
- TestingZoomRestSpringApplicationTests.java - contains 3 testing scenarios (select fastest arrival route, select shortest traveling time route, select route with lowest price)

