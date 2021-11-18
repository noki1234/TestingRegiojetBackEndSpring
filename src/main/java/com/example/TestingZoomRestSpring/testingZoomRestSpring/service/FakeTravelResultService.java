package com.example.TestingZoomRestSpring.testingZoomRestSpring.service;

import com.example.TestingZoomRestSpring.testingZoomRestSpring.model.Route;

import java.time.Instant;
import java.util.*;

public class FakeTravelResultService {
    private List<Route> fakeRoutesList = new ArrayList<>();


    public FakeTravelResultService(){
        fakeRoutesList.add(route1);
        fakeRoutesList.add(route2);
        fakeRoutesList.add(inBookableRoute1);
        fakeRoutesList.add(inBookableRoute2);
        fakeRoutesList.add(unDirectRoute1);
        fakeRoutesList.add(unDirectRoute2);
    }

    public List<Route> getFakeRoutes(Boolean onlyDirect, Boolean onlyAvailable ) {
        List<Route> filteredListOfRoutes = new LinkedList<>();


        for (Route route: fakeRoutesList ) {
            if (onlyAvailable && route.getBookable() && !onlyDirect) {  //ONLY AVAILABLE + DIRECT/INDIRECT
                filteredListOfRoutes.add(route);
            } else if (onlyDirect && route.getTransfersCount() == 0 && !onlyAvailable) { //ONLY DIRECT + AVAILABLE/UNAVAILABLE
                filteredListOfRoutes.add(route);
            } else if ((onlyAvailable && route.getBookable()) && (onlyDirect && route.getTransfersCount() == 0)) { //AVAILABLE + DIRECT
                filteredListOfRoutes.add(route);
            } else if (!onlyAvailable && !onlyDirect){ //ALL
                return fakeRoutesList;
            }
        }
        return filteredListOfRoutes;
    }


    private Route route1 = new Route(
            "route1",
            "372825007",
            Date.from(Instant.parse("2021-11-22T01:15:00.000+01:00")),
            "10204002",
            Date.from(Instant.parse("2021-11-22T03:20:00.000+01:00")),
            new ArrayList(Collections.singleton("BUS")),
            0,
            4,
            10.4,
            10.4,
            9.6,
            9.6,
            1,
            false,
            false,
            false,
            false,
            true,
            true,
            null,
            "02:05 h",
            "FUN_RELAX_SELF_SERVICE"
    );

    private Route route2 = new Route(
            "route2",
            "372825007",
            Date.from(Instant.parse("2021-11-22T02:00:00.000+01:00")),
            "10204002",
            Date.from(Instant.parse("2021-11-22T04:00:00.000+01:00")),
            new ArrayList(Collections.singleton("BUS")),
            0,
            33,
            12.4,
            12.4,
            9.6,
            9.6,
            1,
            false,
            false,
            false,
            false,
            true,
            true,
            null,
            "02:00 h",
            "FUN_RELAX_SELF_SERVICE"
    );


    private Route inBookableRoute1 = new Route(
            "inBookableRoute1",
            "372825007",
            Date.from(Instant.parse("2021-11-22T10:00:00.000+01:00")),
            "10204002",
            Date.from(Instant.parse("2021-11-22T13:30:00.000+01:00")),
            new ArrayList(Collections.singleton("BUS")),
            0,
            0,
            12.4,
            12.4,
            9.6,
            9.6,
            1,
            false,
            false,
            false,
            false,
            true,
            false,
            null,
            "03:30 h",
            "FUN_RELAX_SELF_SERVICE"
    );

    private Route inBookableRoute2 = new Route(
            "inBookableRoute2",
            "372825007",
            Date.from(Instant.parse("2021-11-22T11:00:00.000+01:00")),
            "10204002",
            Date.from(Instant.parse("2021-11-22T15:00:00.000+01:00")),
            new ArrayList(Collections.singleton("BUS")),
            0,
            0,
            6.4,
            10.4,
            9.6,
            9.6,
            1,
            false,
            false,
            false,
            false,
            true,
            false,
            null,
            "04:00 h",
            "FUN_RELAX_SELF_SERVICE"
    );

    private Route unDirectRoute1 = new Route(
            "unDirectRoute1",
            "372825007",
            Date.from(Instant.parse("2021-11-22T11:00:00.000+01:00")),
            "10204002",
            Date.from(Instant.parse("2021-11-22T15:00:00.000+01:00")),
            new ArrayList(Collections.singleton("BUS")),
            2,
            33,
            6.4,
            12.4,
            9.6,
            9.6,
            1,
            false,
            false,
            false,
            false,
            true,
            true,
            null,
            "04:00 h",
            "FUN_RELAX_SELF_SERVICE"
    );

    private Route unDirectRoute2 = new Route(
            "unDirectRoute2",
            "372825007",
            Date.from(Instant.parse("2021-11-22T01:15:00.000+01:00")),
            "10204002",
            Date.from(Instant.parse("2021-11-22T03:20:00.000+01:00")),
            new ArrayList(Collections.singleton("BUS")),
            3,
            4,
            10.4,
            10.4,
            9.6,
            9.6,
            1,
            false,
            false,
            false,
            false,
            true,
            true,
            null,
            "02:05 h",
            "FUN_RELAX_SELF_SERVICE"
    );
}
