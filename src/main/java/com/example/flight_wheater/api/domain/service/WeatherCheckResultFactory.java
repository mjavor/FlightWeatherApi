package com.example.flight_wheater.api.domain.service;

import com.example.flight_wheater.api.domain.dto.Flight;
import com.example.flight_wheater.api.domain.dto.Weather;
import com.example.flight_wheater.api.domain.dto.weather_check.PositiveWeatherCheckBaseResult;
import org.springframework.stereotype.Service;

@Service
public class WeatherCheckResultFactory {

    public PositiveWeatherCheckBaseResult createPositive(
            Flight flight, Weather weather, String strategyName
    ) {
        return null;
    }

    public PositiveWeatherCheckBaseResult createNegative() {
        return null;
    }

    public PositiveWeatherCheckBaseResult createMiddling() {
        return null;
    }

}
