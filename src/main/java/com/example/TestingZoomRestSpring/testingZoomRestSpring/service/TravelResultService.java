package com.example.TestingZoomRestSpring.testingZoomRestSpring.service;

import com.example.TestingZoomRestSpring.testingZoomRestSpring.model.Route;
import com.example.TestingZoomRestSpring.testingZoomRestSpring.model.TravelResult;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

@Service
public class TravelResultService {

    private final WebClient webClient;

    @Autowired
    public TravelResultService() {
        this.webClient = WebClient.builder()
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }


    public TravelResult getAllTravelResults(String fromLocationId, String toLocationId, String departureDate) {
        return webClient.get().uri(getSearchTravelUri(fromLocationId, toLocationId, departureDate))
                .retrieve().bodyToFlux(TravelResult.class).blockFirst();
    }

    public List<Route> getRoutes(String fromLocationId, String toLocationId, String date, Boolean onlyDirect, Boolean onlyAvailable ) {
        List<Route> listOfAllRoutes = getAllTravelResults(fromLocationId, toLocationId, date).getRoutes();
        List<Route> filteredListOfRoutes = new LinkedList<>();


        for (Route route: listOfAllRoutes ) {
            if (onlyAvailable && route.getBookable() && !onlyDirect) {  //ONLY AVAILABLE + DIRECT/INDIRECT
                filteredListOfRoutes.add(route);
            } else if (onlyDirect && route.getTransfersCount() == 0 && !onlyAvailable) { //ONLY DIRECT + AVAILABLE/UNAVAILABLE
                filteredListOfRoutes.add(route);
            } else if ((onlyAvailable && route.getBookable()) && (onlyDirect && route.getTransfersCount() == 0)) { //AVAILABLE + DIRECT
                filteredListOfRoutes.add(route);
            } else if (!onlyAvailable && !onlyDirect){ //ALL
                return listOfAllRoutes;
            }
        }
        return filteredListOfRoutes;
    }


    public URI getSearchTravelUri(String fromLocationId, String toLocationId, String departureDate) {
        try {
            return new URIBuilder()
                    .setScheme("https")
                    .setHost("brn-ybus-pubapi.sa.cz")
                    .setPath("restapi/routes/search/simple")
                    .setParameter("tarrifs", "REGULAR")
                    .setParameter("toLocationType", "CITY")
                    .setParameter("toLocationId", toLocationId)
                    .setParameter("fromLocationType", "CITY")
                    .setParameter("fromLocationId", fromLocationId)
                    .setParameter("departureDate", departureDate)
                    .build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }



}
