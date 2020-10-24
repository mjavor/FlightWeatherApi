package com.example.flight_wheater.api.domain.dto.weather_check;

import com.example.flight_wheater.api.domain.WeatherCheckResultType;
import com.example.flight_wheater.api.domain.dto.Flight;
import com.example.flight_wheater.api.domain.dto.Weather;

public class MiddlingWeatherCheckBaseResult extends WeatherCheckBaseResult {

    MiddlingWeatherCheckBaseResult(Flight flight, Weather weather, String weatherCheckStrategyName) {
        super(flight, weather, weatherCheckStrategyName);
    }

    @Override
    public WeatherCheckResultType getType() {
        return WeatherCheckResultType.middling;
    }
}
