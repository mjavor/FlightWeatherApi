package com.example.flight_wheater.api.domain.service;

import com.example.flight_wheater.api.domain.dto.Flight;
import com.example.flight_wheater.api.domain.dto.Weather;
import com.example.flight_wheater.api.domain.dto.weather_check.MiddlingWeatherCheckResult;
import com.example.flight_wheater.api.domain.dto.weather_check.NegativeWeatherCheckResult;
import com.example.flight_wheater.api.domain.dto.weather_check.PositiveWeatherCheckResult;
import org.springframework.stereotype.Service;

@Service
public class WeatherCheckResultFactory {

    public PositiveWeatherCheckResult createPositive(
            Flight flight, Weather weather, String strategyName
    ) {
        return new PositiveWeatherCheckResult(flight, weather, strategyName);
    }

    public NegativeWeatherCheckResult createNegative(Flight flight, Weather weather, String strategyName) {
        return new NegativeWeatherCheckResult(flight, weather, strategyName);
    }

    public MiddlingWeatherCheckResult createMiddling(Flight flight, Weather weather, String strategyName) {
        return new MiddlingWeatherCheckResult(flight, weather, strategyName);
    }

}
