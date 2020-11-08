package com.example.flight_wheater.api.ui.controller;

import com.example.flight_wheater.api.domain.dto.weather_check.WeatherCheckBaseResult;
import com.example.flight_wheater.api.domain.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller()
@RequiredArgsConstructor
public class FlightWeatherConditionsController {

    private final FlightService flightService;

    @GetMapping("/")
    void findWeatherComplications() {
        List<WeatherCheckBaseResult> results = flightService.checkWeather();
        int a = 5;
    }

}
