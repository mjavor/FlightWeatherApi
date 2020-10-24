package com.example.flight_wheater.api.infrastructure.service.weather.open_weather_map_api;

import com.example.flight_wheater.api.domain.dto.Coordinates;
import com.example.flight_wheater.api.infrastructure.service.weather.open_weather_map_api.dto.RawWeatherCoordinatesData;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class OpenWeatherMapApi {

    private static final String QUERY_STRING_HEADER_PARAM_NAME = "useQueryString";
    private static final String QUERY_STRING_HEADER_PARAM_VALUE = "true";

    private static final String HEADER_SECRET_NAME = "x-rapidapi-key";

    private static final String UNITS_PARAM_NAME = "units";
    private static final String UNITS_PARAM_VALUE = "metric";

    private final String apiSecretKey;
    
    private final String baseUrl;
    
    OpenWeatherMapApi(
            @Value("${open_weather_map_api.x_rapid_api_key}")
            String apiSecretKey,
            @Value("${open_weather_map_api.base_url}")
            String baseUrl
    ) {
        this.apiSecretKey = apiSecretKey;
        this.baseUrl = baseUrl;
    }

    List<RawWeatherCoordinatesData> getRawWeatherData(List<Coordinates> coordinatesList) {
        return coordinatesList
                .stream()
                .map(this::getRawWeather)
                .filter(Objects::nonNull)
                .collect(Collectors.toList())
                ;
    }

    private RawWeatherCoordinatesData getRawWeather(Coordinates coordinates) {
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            URI apiUri = UriComponentsBuilder
                    .fromUriString(String.format("%s/weather", baseUrl))
                    .queryParam("lon", coordinates.longitude())
                    .queryParam("lat", coordinates.latitude())
                    .queryParam(UNITS_PARAM_NAME, UNITS_PARAM_VALUE)
                    .build()
                    .toUri()
                    ;
            HttpGet request = new HttpGet(apiUri);

            request.addHeader(QUERY_STRING_HEADER_PARAM_NAME, QUERY_STRING_HEADER_PARAM_VALUE);
            request.addHeader(HEADER_SECRET_NAME, apiSecretKey);

            HttpResponse response = httpClient.execute(request);
            String json = EntityUtils.toString(response.getEntity(), "UTF-8");
            return new RawWeatherCoordinatesData(json, coordinates);
        } catch (Exception exception) {
            return null;
        }
    }
}
