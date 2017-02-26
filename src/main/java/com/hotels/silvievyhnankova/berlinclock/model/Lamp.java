package com.hotels.silvievyhnankova.berlinclock.model;

public class Lamp {

    private final Status status;

    public Lamp(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public enum Status {
        RED_ON, YELLOW_ON, OFF
    }
}
