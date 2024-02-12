package com.geektrust.backend.dtos;

import com.geektrust.backend.entity.PassengerType;

public class PassengerCount implements Comparable<PassengerCount>{

    private final PassengerType passengerType;
    private  int passengerCount;

    public PassengerCount(PassengerType passengerType, int passengerCount) {
        this.passengerType = passengerType;
        this.passengerCount = passengerCount;
    }

    public PassengerType getPassengerType() {
        return passengerType;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    @Override
    public String toString() {
        return passengerType + " " + passengerCount;
    }

    @Override
    public int compareTo(PassengerCount obj) {
        return obj.getPassengerCount()-this.getPassengerCount() == 0 ?
                this.passengerType.name().charAt(0) - obj.passengerType.name().charAt(0)
                : obj.getPassengerCount()-this.getPassengerCount();
    }

}
