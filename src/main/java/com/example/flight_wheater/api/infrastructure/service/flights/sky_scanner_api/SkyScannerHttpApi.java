package com.example.flight_wheater.api.infrastructure.service.flights.sky_scanner_api;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class SkyScannerHttpApi {

    private static final String API_ACCESS_KEY_PARAM_NAME = "access_key";

    private static final String API_FLIGHT_STATUS_PARAM_NAME = "flight_status";

    private static final String API_FLIGHT_STATUS_PARAM_ACTIVE_VALUE = "active";

    private final String apiBaseUrl;

    private final String accessKey;

    SkyScannerHttpApi(
            @Value("${sky_scanner_api.base_url}")
            String skyScannerApiBaseUrl,
            @Value("${sky_scanner_api.access_key}")
            String skyScannerAccessKey
    ) {
        apiBaseUrl = skyScannerApiBaseUrl;
        accessKey = skyScannerAccessKey;
    }

    String getRawFlights() {
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            URI apiUri = UriComponentsBuilder
                    .fromUriString(String.format("%s/flights", apiBaseUrl))
                    .queryParam(API_ACCESS_KEY_PARAM_NAME, accessKey)
                    .queryParam(API_FLIGHT_STATUS_PARAM_NAME, API_FLIGHT_STATUS_PARAM_ACTIVE_VALUE)
                    .build()
                    .toUri()
                    ;
            HttpGet request = new HttpGet(apiUri);

            HttpResponse response = httpClient.execute(request);
            return EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (Exception e) {
            return "";
        }
    }
}
