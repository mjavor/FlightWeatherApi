package com.example.flight_wheater.api.domain.service;

import com.example.flight_wheater.api.domain.dto.Flight;
import com.example.flight_wheater.api.domain.dto.Weather;
import com.example.flight_wheater.api.domain.dto.weather_check.WeatherCheckBaseResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WeatherConditionChecker {

    private final Set<WeatherCheckStrategy> weatherCheckStrategies;

    public List<WeatherCheckBaseResult> check(Map<Flight, Weather> flightWeatherMap) {

        return flightWeatherMap
                .entrySet()
                .stream()
                .map(this::checkForEntry)
                .flatMap(Collection::stream)
                .collect(Collectors.toList())
                 ;
    }

    private List<WeatherCheckBaseResult> checkForEntry(
            Map.Entry<Flight, Weather> flightWeatherEntry
    ) {
        return weatherCheckStrategies
                .stream()
                .map(weatherCheckStrategy -> weatherCheckStrategy.checkWeather(
                        flightWeatherEntry.getKey(),
                        flightWeatherEntry.getValue())
                )
                .collect(Collectors.toList())
                ;
    }
}
