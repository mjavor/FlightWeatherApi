package com.example.flight_wheater.api.domain.dto;

public record Weather (
        String name,
        String description,
        double temperature,
        double feelsTemperature,
        int visibilityFactor,
        double windSpeed,
        int windAngle,
        Coordinates coordinates
) {}
