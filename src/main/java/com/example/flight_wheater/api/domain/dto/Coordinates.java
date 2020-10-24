package com.example.flight_wheater.api.domain.dto;

public record Coordinates(
        double latitude,
        double longitude
) {
    private final static double MAX_LATITUDE = 180.0;
    private final static double MIN_LATITUDE = -180.0;

    private final static double MAX_LONGITUDE = 90.0;
    private final static double MIN_LONGITUDE = -90.0;

    public Coordinates(double latitude, double longitude) {
        if (longitude > MAX_LATITUDE || longitude < MIN_LATITUDE) {
            throw new IllegalArgumentException(
                    String.format("Invalid geo long value %3.4f", longitude)
            );
        }

        if (latitude > MAX_LONGITUDE || latitude < MIN_LONGITUDE) {
            throw new IllegalArgumentException(
                    String.format("Invalid geo lat value %3.4f", longitude)
            );
        }

        this.latitude = latitude;
        this.longitude = longitude;
    }
}
