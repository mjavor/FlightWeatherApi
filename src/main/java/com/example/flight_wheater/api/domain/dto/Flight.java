package com.example.flight_wheater.api.domain.dto;

public record Flight (
        String departureAirportName,
        String arrivalAirportName,
        String airlineName,
        String flightId,
        Coordinates lastKnownCoordinates,
        boolean isGround
){}
