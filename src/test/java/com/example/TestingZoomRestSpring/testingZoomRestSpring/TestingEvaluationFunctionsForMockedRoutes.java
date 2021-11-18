package com.example.TestingZoomRestSpring.testingZoomRestSpring;

import com.example.TestingZoomRestSpring.testingZoomRestSpring.api.FakeTravelResultController;
import com.example.TestingZoomRestSpring.testingZoomRestSpring.service.FakeTravelResultService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class TestingEvaluationFunctionsForMockedRoutes {


    FakeTravelResultService fakeTravelResultService = new FakeTravelResultService();
    FakeTravelResultController fakeTravelResultController = new FakeTravelResultController(fakeTravelResultService);

    //Mocked Routes (find in 'FakeTravelResultService')
    //Route1 -           time: 01:15-03:20, travelTime: 02:05h, price: 10.4, available: true, direct: true
    //Route2 -           time: 02:00-04:00, travelTime: 02:00h, price: 12.4, available: true, direct: true
    //InBookableRoute1 - time: 10:00-13:30, travelTime: 03:30h, price: 12.4, available: false, direct: true
    //InBookableRoute2 - time: 11:00-15:00, travelTime: 04:00h, price: 6.4, available: false, direct: true
    //UnDirectRoute1 -   time: 11:00-15:00, travelTime: 04:00h, price: 6.4, available: true, direct: false
    //UnDirectRoute2 -   time: 01:15-03:20, travelTime: 02:50h, price: 10.4, available: true, direct: false


    @Test
    public void testEvaluationOfGettingOnlyDirectRoutes(){
        int countOfDirectRoutes = fakeTravelResultService.getFakeRoutes(true, false).size();
        Assert.isTrue(countOfDirectRoutes == 4, "Expected 4 routes but was: " + countOfDirectRoutes);
    }

    @Test
    public void testEvaluationOfGettingOnlyAvailableRoutes(){
        int countOfAvailableRoutes = fakeTravelResultService.getFakeRoutes(false, true).size();
        Assert.isTrue(countOfAvailableRoutes == 4, "Expected 4 routes but was: " + countOfAvailableRoutes);
    }


    @Test
    public void testEvaluationOfGettingOnlyDirectRoutesAndOnlyAvailable(){
        int countOfDirectAndAvailableRoutes = fakeTravelResultService.getFakeRoutes(true, true).size();
        Assert.isTrue(countOfDirectAndAvailableRoutes == 2, "Expected 2 routes but was: " + countOfDirectAndAvailableRoutes);
    }

    @Test
    public void testEvaluationOfGettingAllRoutes(){
        int allRoutes = fakeTravelResultController.getAllFakeRoutes().size();
        Assert.isTrue(allRoutes == 6, "Expected 6 routes but was: " + allRoutes);
    }

    //---------------- FASTEST, SHORTEST, LOWEST PRICE TESTS ---------------------------//
    @Test
    void getFastestArrival_AvailableDirect_Route(){
        String fastestRouteId = fakeTravelResultController.getFastestArrivalRoute( true, true).getId();
        Assert.isTrue(fastestRouteId.equals("route1"), "Expected 'route1' but was: " + fastestRouteId);
    }

    @Test
    void getShortestTimeTraveling_AvailableDirect_Route(){
        String shortestRouteId = fakeTravelResultController.getShortestTimeTravelingRoute( true, true).getId();
        Assert.isTrue(shortestRouteId.equals("route2"), "Expected 'route2' but was: " + shortestRouteId);
    }

    @Test
    void getLowestPrice_AvailableDirect_Route(){
        String lowestPriceRouteId = fakeTravelResultController.getLowestPriceRoute( true, true).getId();
        Assert.isTrue(lowestPriceRouteId.equals("route1"), "Expected 'route1' but was: " + lowestPriceRouteId);
    }

}
