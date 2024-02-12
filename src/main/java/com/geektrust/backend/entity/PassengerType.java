package com.geektrust.backend.entity;

public enum PassengerType {
    ADULT(200),
    SENIOR_CITIZEN(100),
    KID(50);

    private final int value;

    PassengerType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
