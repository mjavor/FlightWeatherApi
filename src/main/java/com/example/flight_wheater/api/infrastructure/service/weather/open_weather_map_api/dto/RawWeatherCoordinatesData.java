package com.example.flight_wheater.api.infrastructure.service.weather.open_weather_map_api.dto;

import com.example.flight_wheater.api.domain.dto.Coordinates;

public record RawWeatherCoordinatesData(
        String rawData,
        Coordinates coordinates
) {}
