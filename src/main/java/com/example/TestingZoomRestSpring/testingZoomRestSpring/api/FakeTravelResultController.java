package com.example.TestingZoomRestSpring.testingZoomRestSpring.api;

import com.example.TestingZoomRestSpring.testingZoomRestSpring.Utils;
import com.example.TestingZoomRestSpring.testingZoomRestSpring.model.Route;
import com.example.TestingZoomRestSpring.testingZoomRestSpring.service.FakeTravelResultService;
import java.util.List;

public class FakeTravelResultController {

    private final FakeTravelResultService fakeTravelResultService;

    public FakeTravelResultController(FakeTravelResultService fakeTravelResultService){
        this.fakeTravelResultService = fakeTravelResultService;
    }

    public List<Route> getAllFakeRoutes(){
        return fakeTravelResultService.getFakeRoutes(false, false);
    }

    public Route getLowestPriceRoute(Boolean onlyDirect, Boolean onlyAvailable){
        List<Route> listOfAllRoutes =  fakeTravelResultService.getFakeRoutes(onlyDirect, onlyAvailable);
        Route lowestPriceRoute = listOfAllRoutes.get(0);

        for (Route route: listOfAllRoutes){
            lowestPriceRoute = (lowestPriceRoute.getPriceFrom() > route.getPriceFrom())?  route : lowestPriceRoute;
        }

        return lowestPriceRoute;
    }

    public Route getShortestTimeTravelingRoute(Boolean onlyDirect, Boolean onlyAvailable){
        List<Route> listOfAllRoutes =  fakeTravelResultService.getFakeRoutes(onlyDirect, onlyAvailable);
        Route shortestTimeTravelRoute = listOfAllRoutes.get(0);

        for (Route route: listOfAllRoutes){
            shortestTimeTravelRoute = (Utils.getInstance().getDateFromTime(shortestTimeTravelRoute.getTravelTime()).after(Utils.getInstance().getDateFromTime(route.getTravelTime())))?  route : shortestTimeTravelRoute;
        }

        return shortestTimeTravelRoute;
    }

    public Route getFastestArrivalRoute(Boolean onlyDirect, Boolean onlyAvailable){
        List<Route> listOfAllRoutes =  fakeTravelResultService.getFakeRoutes(onlyDirect, onlyAvailable);
        Route fastestArrivalRoute = listOfAllRoutes.get(0);

        for (Route route: listOfAllRoutes){
            fastestArrivalRoute = (Utils.getInstance().extractTimeFromDate(fastestArrivalRoute.getArrivalTime()).after(Utils.getInstance().extractTimeFromDate(route.getArrivalTime())))?  route : fastestArrivalRoute;
        }

        return fastestArrivalRoute;
    }

}
