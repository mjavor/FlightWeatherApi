package com.example.flight_wheater.api.infrastructure.service.weather.open_weather_map_api;

import com.example.flight_wheater.api.domain.dto.Weather;
import com.example.flight_wheater.api.infrastructure.service.weather.open_weather_map_api.dto.RawWeatherCoordinatesData;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OpenWeatherMapApiResourceParser {

    private static final int CONSIDER_WEATHER_ID = 0;

    List<Weather> parseRawWeathersData(List<RawWeatherCoordinatesData> rawWeathersData) {
        return rawWeathersData
                .stream()
                .map(this::parseRawWeatherData)
                .collect(Collectors.toList())
                ;
    }

    private Weather parseRawWeatherData(RawWeatherCoordinatesData rawWeatherData) {
        JSONObject weather = new JSONObject(rawWeatherData.rawData());

        JSONObject weatherDetails = weather.getJSONArray("weather").getJSONObject(CONSIDER_WEATHER_ID);
        JSONObject mainMetrics = weather.getJSONObject("main");
        JSONObject windMetrics = weather.getJSONObject("wind");

        return new Weather(
                weatherDetails.getString("main"),
                weatherDetails.getString("description"),
                mainMetrics.getDouble("temp"),
                mainMetrics.getDouble("feels_like"),
                weather.getInt("visibility"),
                windMetrics.getDouble("speed"),
                windMetrics.getInt("deg"),
                rawWeatherData.coordinates()
        );
    }
}
