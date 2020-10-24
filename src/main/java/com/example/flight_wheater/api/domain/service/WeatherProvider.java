package com.example.flight_wheater.api.domain.service;

import com.example.flight_wheater.api.domain.dto.Coordinates;
import com.example.flight_wheater.api.domain.dto.Weather;

import java.util.List;

public interface WeatherProvider {

    List<Weather> provideWeatherForCoordinatesList(List<Coordinates> coordinates);
}
