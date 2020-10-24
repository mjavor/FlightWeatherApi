package com.example.flight_wheater.api.domain.service.weather_check_strategies;

import com.example.flight_wheater.api.domain.service.WeatherCheckResultFactory;
import com.example.flight_wheater.api.domain.dto.Flight;
import com.example.flight_wheater.api.domain.dto.Weather;
import com.example.flight_wheater.api.domain.dto.weather_check.WeatherCheckBaseResult;
import org.springframework.stereotype.Component;

@Component
public class CriticalLowTemperatureStrategy extends BaseWeatherCheckStrategy {

    private static final String STRATEGY_NAME = "CriticalLowTemperatureStrategy";

    public CriticalLowTemperatureStrategy(WeatherCheckResultFactory weatherCheckResultFactory) {
        super(weatherCheckResultFactory);
    }

    @Override
    public WeatherCheckBaseResult checkWeather(Flight flight, Weather weather) {
        return null;
    }

    @Override
    public String getStrategyName() {
        return STRATEGY_NAME;
    }
}
