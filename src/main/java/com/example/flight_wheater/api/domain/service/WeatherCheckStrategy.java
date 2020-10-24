package com.example.flight_wheater.api.domain.service;

import com.example.flight_wheater.api.domain.dto.Flight;
import com.example.flight_wheater.api.domain.dto.Weather;
import com.example.flight_wheater.api.domain.dto.weather_check.WeatherCheckBaseResult;

public interface WeatherCheckStrategy {

    WeatherCheckBaseResult checkWeather(Flight flight, Weather weather);

    String getStrategyName();
}
