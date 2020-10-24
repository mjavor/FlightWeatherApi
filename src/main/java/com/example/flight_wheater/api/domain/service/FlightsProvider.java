package com.example.flight_wheater.api.domain.service;

import com.example.flight_wheater.api.domain.dto.Flight;

import java.util.List;

public interface FlightsProvider {

    List<Flight> provideFlights();
}
