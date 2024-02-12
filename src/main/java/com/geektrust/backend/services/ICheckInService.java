package com.geektrust.backend.services;

import com.geektrust.backend.entity.PassengerCheckIn;
import com.geektrust.backend.entity.Station;
import com.geektrust.backend.entity.PassengerType;
import java.util.Map;

public interface ICheckInService {

    public void checkInPassenger(PassengerCheckIn passengerCheckIn);
    public Map<Station, Map<PassengerType, Integer>> getStationTypeCount();
    public Map<String, Integer> getStationAmountMap();
    public Map<String, Integer> getReturnAmountMap();

}
