package com.geektrust.backend.services.impl;

import com.geektrust.backend.entity.PassengerCheckIn;
import com.geektrust.backend.entity.PassengerType;
import com.geektrust.backend.entity.Station;
import com.geektrust.backend.services.ICheckInService;
import com.geektrust.backend.services.IMetroCardService;
import java.util.HashMap;
import java.util.Map;

public class CheckInService implements ICheckInService {
    Map<String, Station> passengerMap;
    Map<String, Integer> stationAmountMap;
    Map<Station, Map<PassengerType, Integer>> stationTypeCount;
    Map<String, Integer> returnAmountMap;
    IMetroCardService metroCardService;

    public CheckInService(IMetroCardService metroCardService) {
        this.metroCardService = metroCardService;
        passengerMap = new HashMap<>();
        stationAmountMap = new HashMap<>();
        stationTypeCount = new HashMap<>();
        returnAmountMap = new HashMap<>();
        for (Station station : Station.values()) {
            stationAmountMap.put(station.name(), 0);
            returnAmountMap.put(station.name(), 0);
            stationTypeCount.put(station, new HashMap<>());
        }
    }

    private void updatePCount(Map<PassengerType, Integer> passengers, PassengerType passengerType, Station station) {
        int val=passengers.getOrDefault(passengerType, 0);
        passengers.put(passengerType, val+1);
        stationTypeCount.put(station, passengers);
    }

    @Override
    public void checkInPassenger(PassengerCheckIn passengerCheckIn) {
        String cardId = passengerCheckIn.getMetroCardId();
        if (!passengerMap.containsKey(cardId)){
            int amount = passengerCheckIn.getPassengerType().getValue();
            int revenueCollected = stationAmountMap.get(passengerCheckIn.getBoardingStation().name()) + amount;
            int remaining = metroCardService.transaction(cardId, amount);
            if (remaining != -1) revenueCollected += remaining * 0.02;
            passengerMap.put(cardId, passengerCheckIn.getBoardingStation());
            stationAmountMap.put(passengerCheckIn.getBoardingStation().name(), revenueCollected);
        } else  {
            int discountAmount = passengerCheckIn.getPassengerType().getValue() / 2;
            int revenueCollected = stationAmountMap.get(passengerCheckIn.getBoardingStation().name()) + discountAmount;
            int returnAmount = returnAmountMap.get(passengerCheckIn.getBoardingStation().name()) + discountAmount;
            returnAmountMap.put(passengerCheckIn.getBoardingStation().name(), returnAmount);
            int remaining = metroCardService.transaction(cardId, discountAmount);
            if (remaining != -1) revenueCollected += remaining * 0.02;
            passengerMap.remove(cardId);
            stationAmountMap.put(passengerCheckIn.getBoardingStation().name(), revenueCollected);
        }
        updatePCount(stationTypeCount.get(passengerCheckIn.getBoardingStation()), passengerCheckIn.getPassengerType(), passengerCheckIn.getBoardingStation());
    }


    @Override
    public Map<Station, Map<PassengerType, Integer>> getStationTypeCount() {
        return this.stationTypeCount;
    }

    @Override
    public Map<String, Integer> getStationAmountMap() {
        return this.stationAmountMap;
    }

    @Override
    public Map<String, Integer> getReturnAmountMap() {
        return this.returnAmountMap;
    }
}
