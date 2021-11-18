package com.example.TestingZoomRestSpring.testingZoomRestSpring.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class Route {
    private final String id;
    private final String departureStationId;
    private final Date departureTime;
    private final String arrivalStationId;
    private final Date arrivalTime;
    private final List<String> vehicleTypes;
    private final Integer transfersCount;
    private final Integer freeSeatsCount;
    private final Double priceFrom;
    private final Double priceTo;
    private final Double creditPriceFrom;
    private final Double creditPriceTo;
    private final Integer pricesCount;
    private final Boolean actionPrice;
    private final Boolean surcharge;
    private final Boolean notices;
    private final Boolean support;
    private final Boolean nationalTrip;
    private final Boolean bookable;
    private final Object delay;
    private final String travelTime;
    private final String vehicleStandardKey;

    public Route( @JsonProperty("id") String id,
                  @JsonProperty("departureStationId") String departureStationId,
                  @JsonProperty("departureTime") Date departureTime,
                  @JsonProperty("arrivalStationId") String arrivalStationId,
                  @JsonProperty("arrivalTime") Date arrivalTime,
                  @JsonProperty("vehicleTypes") List<String> vehicleTypes,
                  @JsonProperty("transfersCount") Integer transfersCount,
                  @JsonProperty("freeSeatsCount") Integer freeSeatsCount,
                  @JsonProperty("priceFrom") Double priceFrom,
                  @JsonProperty("priceTo") Double priceTo,
                  @JsonProperty("creditPriceFrom") Double creditPriceFrom,
                  @JsonProperty("creditPriceTo") Double creditPriceTo,
                  @JsonProperty("pricesCount") Integer pricesCount,
                  @JsonProperty("actionPrice") Boolean actionPrice,
                  @JsonProperty("surcharge") Boolean surcharge,
                  @JsonProperty("notices") Boolean notices,
                  @JsonProperty("support") Boolean support,
                  @JsonProperty("nationalTrip") Boolean nationalTrip,
                  @JsonProperty("bookable") Boolean bookable,
                  @JsonProperty("delay") Object delay,
                  @JsonProperty("travelTime") String travelTime,
                  @JsonProperty("vehicleStandardKey") String vehicleStandardKey) {
            this.id = id;
            this.departureStationId = departureStationId;
            this.departureTime = departureTime;
            this.arrivalStationId = arrivalStationId;
            this.arrivalTime = arrivalTime;
            this.vehicleTypes = vehicleTypes;
            this.transfersCount = transfersCount;
            this.freeSeatsCount = freeSeatsCount;
            this.priceFrom = priceFrom;
            this.priceTo = priceTo;
            this.creditPriceFrom = creditPriceFrom;
            this.creditPriceTo = creditPriceTo;
            this.pricesCount = pricesCount;
            this.actionPrice = actionPrice;
            this.surcharge = surcharge;
            this.notices = notices;
            this.support = support;
            this.nationalTrip = nationalTrip;
            this.bookable = bookable;
            this.delay = delay;
            this.travelTime = travelTime;
            this.vehicleStandardKey = vehicleStandardKey;
    }


    public String getId() {
        return id;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public Date getArrivalTime() {return arrivalTime;}

    public Integer getTransfersCount() {
        return transfersCount;
    }

    public Double getPriceFrom() {
        return priceFrom;
    }

    public Boolean getBookable() {
        return bookable;
    }

    public String getTravelTime() {

        return travelTime.replace(" h", "");
    }
}
