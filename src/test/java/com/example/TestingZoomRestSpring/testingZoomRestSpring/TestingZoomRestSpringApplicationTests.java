package com.example.TestingZoomRestSpring.testingZoomRestSpring;

import com.example.TestingZoomRestSpring.testingZoomRestSpring.api.TravelResultController;
import com.example.TestingZoomRestSpring.testingZoomRestSpring.service.TravelResultService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.DayOfWeek;
import static io.restassured.RestAssured.when;

@SpringBootTest
class TestingZoomRestSpringApplicationTests {

	TravelResultService travelResultService = new TravelResultService();
	TravelResultController travelResultController = new TravelResultController(travelResultService);
	private final String ostravaId = "10202000";
	private final String brnoId = "10202002";

	@Test
	void getFastestArrival_AvailableDirect_Route(){
		when().get(travelResultService.getSearchTravelUri(ostravaId, brnoId, Utils.getInstance().getNearestDayFromCalendar(DayOfWeek.MONDAY).toString())).then().assertThat().statusCode(200);
		System.out.println("SHORTEST TRAVELING ROUTE: " + travelResultController.getFastestArrivalRoute(ostravaId, brnoId, DayOfWeek.MONDAY, true, true).getDepartureTime());
	}

	@Test
	void getShortestTimeTraveling_AvailableDirect_Route(){
		when().get(travelResultService.getSearchTravelUri(ostravaId, brnoId, Utils.getInstance().getNearestDayFromCalendar(DayOfWeek.MONDAY).toString())).then().assertThat().statusCode(200);
		System.out.println("SHORTEST TRAVELING ROUTE: " + travelResultController.getShortestTimeTravelingRoute(ostravaId, brnoId, DayOfWeek.MONDAY, true, true).getDepartureTime());
	}

	@Test
	void getLowestPrice_AvailableDirect_Route(){
		when().get(travelResultService.getSearchTravelUri(ostravaId, brnoId, Utils.getInstance().getNearestDayFromCalendar(DayOfWeek.MONDAY).toString())).then().assertThat().statusCode(200);
		System.out.println("LOWEST PRICE ROUTE: " + travelResultController.getLowestPriceRoute(ostravaId, brnoId, DayOfWeek.MONDAY, true, true).getDepartureTime());
	}

}
