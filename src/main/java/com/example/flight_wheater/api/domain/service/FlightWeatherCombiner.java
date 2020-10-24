package com.example.flight_wheater.api.domain.service;

import com.example.flight_wheater.api.domain.dto.Flight;
import com.example.flight_wheater.api.domain.dto.Coordinates;
import com.example.flight_wheater.api.domain.dto.Weather;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FlightWeatherCombiner {

    Map<Flight, Weather> combineFlightAndWeatherByCoordinates(
            List<Flight> flights,
            List<Weather> weathers
    ) {
        Map<Flight, Weather> flightWeatherMap = new HashMap<>();

        for (Flight flight: flights) {
            Coordinates flightCoordinates = flight.lastKnownCoordinates();
            boolean weatherDataFound = false;

            for (Weather weather: weathers) {
                if (!flightCoordinates.equals(weather.coordinates())) {
                    continue;
                }

                flightWeatherMap.put(flight, weather);
                weatherDataFound = true;
                break;
            }

            if (!weatherDataFound) {
                flightWeatherMap.put(flight, null);
            }
        }

        return flightWeatherMap;
    }
}
