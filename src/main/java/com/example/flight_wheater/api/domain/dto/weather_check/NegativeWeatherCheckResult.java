package com.example.flight_wheater.api.domain.dto.weather_check;

import com.example.flight_wheater.api.domain.WeatherCheckResultType;
import com.example.flight_wheater.api.domain.dto.Flight;
import com.example.flight_wheater.api.domain.dto.Weather;

public class NegativeWeatherCheckResult extends WeatherCheckBaseResult {

    public NegativeWeatherCheckResult(Flight flight, Weather weather, String verdictCheckerName) {
        super(flight, weather, verdictCheckerName);
    }

    @Override
    public WeatherCheckResultType getType() {
        return WeatherCheckResultType.negative;
    }
}
