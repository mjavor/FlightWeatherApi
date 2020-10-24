package com.example.flight_wheater.api.domain.service;

import com.example.flight_wheater.api.domain.dto.Coordinates;
import com.example.flight_wheater.api.domain.dto.Flight;
import com.example.flight_wheater.api.domain.dto.Weather;
import com.example.flight_wheater.api.domain.dto.weather_check.WeatherCheckBaseResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightsProvider flightsProvider;

    private final WeatherProvider weatherProvider;

    private final WeatherConditionFlightController weatherConditionFlightController;

    public List<WeatherCheckBaseResult> checkWeather() {
        List<Flight> activeFlights = flightsProvider.provideFlights();
        List<Weather> weathers = weatherProvider.provideWeatherForCoordinatesList(
                extractCoordinatesFromFlights(activeFlights)
        );

        return weatherConditionFlightController.controlWeather(activeFlights, weathers);
    }


    List<Coordinates> extractCoordinatesFromFlights(List<Flight> flights) {
        return flights
                .stream()
                .map(Flight::lastKnownCoordinates)
                .collect(Collectors.toList())
                ;
    }

}
