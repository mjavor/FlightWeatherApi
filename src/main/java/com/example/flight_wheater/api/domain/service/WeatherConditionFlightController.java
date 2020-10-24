package com.example.flight_wheater.api.domain.service;

import com.example.flight_wheater.api.domain.dto.Flight;
import com.example.flight_wheater.api.domain.dto.weather_check.WeatherCheckBaseResult;
import com.example.flight_wheater.api.domain.dto.Weather;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class WeatherConditionFlightController {

    private final WeatherConditionChecker weatherConditionChecker;

    private final FlightWeatherCombiner flightWeatherCombiner;

    List<WeatherCheckBaseResult> controlWeather(List<Flight> activeFlights, List<Weather> weathers) {
        Map<Flight, Weather> map = flightWeatherCombiner.combineFlightAndWeatherByCoordinates(
                activeFlights,
                weathers
        );

        return weatherConditionChecker.check(map);
    }


}
