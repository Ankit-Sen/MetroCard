package com.geektrust.backend.entity;

public class PassengerCheckIn {
    private final String metroCardId;
    private final PassengerType passengerType;
    private final Station boardingStation;

    public PassengerCheckIn(String metroCardId, PassengerType passengerType, Station boardingStation) {
        this.metroCardId = metroCardId;
        this.passengerType = passengerType;
        this.boardingStation = boardingStation;
    }

    public String getMetroCardId() {
        return metroCardId;
    }

    public PassengerType getPassengerType() {
        return passengerType;
    }

    public Station getBoardingStation() {
        return boardingStation;
    }

    @Override
    public String toString() {
        return "PassengerCheckIn{" +
                "metroCardId='" + metroCardId + '\'' +
                ", passengerType=" + passengerType +
                ", boardingStation=" + boardingStation +
                '}';
    }


}
