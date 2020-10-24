package com.example.flight_wheater.api.infrastructure.service.flights.sky_scanner_api;

import com.example.flight_wheater.api.domain.dto.Flight;
import com.example.flight_wheater.api.domain.dto.Coordinates;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SkyScannerApiResourceParser {

    List<Flight> parseToFlights(String flights) {
        JSONObject data = new JSONObject(flights);
        JSONArray flightsData = data.getJSONArray("data");

        return StreamSupport.stream(flightsData.spliterator(), false)
                .map(JSONObject.class::cast)
                .filter(flight -> !flight.isNull("live"))
                .collect(Collectors.toList())
                .stream()
                .map(this::build)
                .limit(10)
                .collect(Collectors.toList())
        ;

    }

    private Flight build(JSONObject flight) {
        JSONObject departureJson = flight.getJSONObject("departure");
        JSONObject arrivalJson = flight.getJSONObject("arrival");
        JSONObject airlineJson = flight.getJSONObject("airline");
        JSONObject flightDetailsJson = flight.getJSONObject("flight");

        JSONObject liveData = flight.getJSONObject("live");

        Coordinates lastKnownFlightCoordinates = new Coordinates(
            liveData.getDouble("latitude"),
            liveData.getDouble("longitude")
        );

        return new Flight(
                departureJson.getString("airport"),
                arrivalJson.getString("airport"),
                airlineJson.getString("name"),
                flightDetailsJson.getString("number"),
                lastKnownFlightCoordinates,
                liveData.getBoolean("is_ground")
        );
    }
}
