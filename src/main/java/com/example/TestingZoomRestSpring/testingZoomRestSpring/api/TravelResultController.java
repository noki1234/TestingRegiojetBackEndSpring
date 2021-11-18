package com.example.TestingZoomRestSpring.testingZoomRestSpring.api;

import com.example.TestingZoomRestSpring.testingZoomRestSpring.Utils;
import com.example.TestingZoomRestSpring.testingZoomRestSpring.model.Route;
import com.example.TestingZoomRestSpring.testingZoomRestSpring.model.TravelResult;
import com.example.TestingZoomRestSpring.testingZoomRestSpring.service.TravelResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.time.DayOfWeek;
import java.util.List;

@RestController
public class TravelResultController {

    private final TravelResultService travelResultService;

    @Autowired
    public TravelResultController(TravelResultService travelResultService){
        this.travelResultService = travelResultService;
    }

    public TravelResult getAllTravelResults(String fromLocationId, String toLocationId, DayOfWeek dayOfWeek){
        return travelResultService.getAllTravelResults(
                fromLocationId,
                toLocationId,
                Utils.getInstance().getNearestDayFromCalendar(dayOfWeek).toString());
    }

    public List<Route> getAllRoutes(String fromLocationId, String toLocationId, DayOfWeek dayOfWeek){
        return travelResultService.getRoutes(
                fromLocationId,
                toLocationId,
                Utils.getInstance().getNearestDayFromCalendar(dayOfWeek).toString(), false, false);
    }


    public Route getLowestPriceRoute(String fromLocationId, String toLocationId, DayOfWeek dayOfWeek, Boolean onlyDirect, Boolean onlyAvailable){
        List<Route> listOfAllRoutes = travelResultService.getRoutes(fromLocationId, toLocationId, Utils.getInstance().getNearestDayFromCalendar(dayOfWeek).toString(), onlyDirect, onlyAvailable);
        Route lowestPriceRoute = listOfAllRoutes.get(0);

        for (Route route: listOfAllRoutes){
            lowestPriceRoute = (lowestPriceRoute.getPriceFrom() > route.getPriceFrom())?  route : lowestPriceRoute;
        }

        return lowestPriceRoute;
    }

    public Route getShortestTimeTravelingRoute(String fromLocationId, String toLocationId, DayOfWeek dayOfWeek, Boolean onlyDirect, Boolean onlyAvailable){
        List<Route> listOfAllRoutes = travelResultService.getRoutes(fromLocationId, toLocationId, Utils.getInstance().getNearestDayFromCalendar(dayOfWeek).toString(), onlyDirect, onlyAvailable);
        Route shortestTimeTravelRoute = listOfAllRoutes.get(0);

        for (Route route: listOfAllRoutes){
            shortestTimeTravelRoute = (Utils.getInstance().getDateFromTime(shortestTimeTravelRoute.getTravelTime()).after(Utils.getInstance().getDateFromTime(route.getTravelTime())))?  route : shortestTimeTravelRoute;
        }

        return shortestTimeTravelRoute;
    }

    public Route getFastestArrivalRoute(String fromLocationId, String toLocationId, DayOfWeek dayOfWeek, Boolean onlyDirect, Boolean onlyAvailable){
        List<Route> listOfAllRoutes = travelResultService.getRoutes(fromLocationId, toLocationId, Utils.getInstance().getNearestDayFromCalendar(dayOfWeek).toString(), onlyDirect, onlyAvailable);
        Route fastestArrivalRoute = listOfAllRoutes.get(0);

        for (Route route: listOfAllRoutes){
            fastestArrivalRoute = (Utils.getInstance().extractTimeFromDate(fastestArrivalRoute.getArrivalTime()).after(Utils.getInstance().extractTimeFromDate(route.getArrivalTime())))?  route : fastestArrivalRoute;
        }

        return fastestArrivalRoute;
    }

}
