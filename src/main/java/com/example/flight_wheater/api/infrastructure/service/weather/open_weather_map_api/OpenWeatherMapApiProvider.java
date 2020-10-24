package com.example.flight_wheater.api.infrastructure.service.weather.open_weather_map_api;

import com.example.flight_wheater.api.domain.dto.Coordinates;
import com.example.flight_wheater.api.domain.dto.Weather;
import com.example.flight_wheater.api.domain.service.WeatherProvider;
import com.example.flight_wheater.api.infrastructure.service.weather.open_weather_map_api.dto.RawWeatherCoordinatesData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OpenWeatherMapApiProvider implements WeatherProvider {

    private final OpenWeatherMapApi openWeatherMapApi;

    private final OpenWeatherMapApiResourceParser parser;

    @Override
    public List<Weather> provideWeatherForCoordinatesList(List<Coordinates> coordinates) {
        List<RawWeatherCoordinatesData> rawWeathersData = openWeatherMapApi.getRawWeatherData(coordinates);

        return parser.parseRawWeathersData(rawWeathersData);
    }
}
