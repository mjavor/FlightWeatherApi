package com.example.flight_wheater.api.domain.service.weather_check_strategies;

import com.example.flight_wheater.api.domain.service.WeatherCheckResultFactory;
import com.example.flight_wheater.api.domain.service.WeatherCheckStrategy;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor()
public abstract class BaseWeatherCheckStrategy implements WeatherCheckStrategy {

    protected final WeatherCheckResultFactory weatherCheckResultFactory;
}
