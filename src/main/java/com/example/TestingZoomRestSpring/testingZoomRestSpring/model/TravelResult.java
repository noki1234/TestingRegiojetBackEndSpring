package com.example.TestingZoomRestSpring.testingZoomRestSpring.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class TravelResult {
    private final List<Route> routes;
    private final String routesMessage;
    private final List<Object> bannerBubbles;
    private final List<Object> textBubbles;

    public TravelResult(@JsonProperty("routes") List<Route> routes,
                        @JsonProperty("routesMessage") String routesMessage,
                        @JsonProperty("bannerBubbles") List<Object> bannerBubbles,
                        @JsonProperty("textBubbles") List<Object> textBubbles) {
        this.routes = routes;
        this.routesMessage = routesMessage;
        this.bannerBubbles = bannerBubbles;
        this.textBubbles = textBubbles;
    }

    public List<Route> getRoutes() {
        return routes;
    }



}
