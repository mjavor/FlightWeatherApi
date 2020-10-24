package com.example.flight_wheater.api.domain.dto.weather_check;

import com.example.flight_wheater.api.domain.WeatherCheckResultType;
import com.example.flight_wheater.api.domain.dto.Flight;
import com.example.flight_wheater.api.domain.dto.Weather;

public abstract class WeatherCheckBaseResult {

    private final Flight flight;

    private final Weather weather;

    private final String weatherCheckStrategyName;

    private String description;

    WeatherCheckBaseResult(
            Flight flight,
            Weather weather,
            String weatherCheckStrategyName
    ) {
        this.flight = flight;
        this.weather = weather;
        this.weatherCheckStrategyName = weatherCheckStrategyName;
    }

    public Flight getFlight() {
        return flight;
    }

    public Weather getWeather() {
        return weather;
    }

    public String getWeatherCheckStrategyName() {
        return weatherCheckStrategyName;
    }

    public abstract WeatherCheckResultType getType();

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
