package com.example.flight_wheater.api.infrastructure.service.flights.sky_scanner_api;

import com.example.flight_wheater.api.domain.dto.Flight;
import com.example.flight_wheater.api.domain.service.FlightsProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SkyScannerApiFlightsProvider implements FlightsProvider {

    private final SkyScannerHttpApi skyScannerHttpApi;

    private final SkyScannerApiResourceParser skyScannerApiResourceParser;

    @Override
    public List<Flight> provideFlights(){
        try {
            String data = skyScannerHttpApi.getRawFlights();
            return skyScannerApiResourceParser.parseToFlights(data);
        } catch (Exception e) {
            return null;
        }
    }
}
