package com.geektrust.backend.services.impl;

import com.geektrust.backend.dtos.PassengerCount;
import com.geektrust.backend.entity.PassengerType;
import com.geektrust.backend.entity.Station;
import com.geektrust.backend.services.ICheckInService;
import com.geektrust.backend.services.IPrintSummaryService;

import java.util.Map;
import java.util.PriorityQueue;

public class PrintSummaryService implements IPrintSummaryService {
    ICheckInService checkInService;

    public PrintSummaryService(ICheckInService checkInService) {
        this.checkInService = checkInService;
    }

    @Override
    public void printSummary() {
        Map<Station, Map<PassengerType, Integer>> stationTypeCountMap = checkInService.getStationTypeCount();
        Map<String, Integer> stationAmountMap = checkInService.getStationAmountMap();
        Map<String, Integer> returnAmountMap = checkInService.getReturnAmountMap();
        for (Station station : Station.values()) {
            System.out.println("TOTAL_COLLECTION " + station.name() + " " + stationAmountMap.get(station.name()) + " " + returnAmountMap.get(station.name()));
            System.out.println("PASSENGER_TYPE_SUMMARY");
            PriorityQueue<PassengerCount> sortedPassengerCount = toSort(stationTypeCountMap.get(station));
            while (!sortedPassengerCount.isEmpty()) {
                PassengerCount passengerCount = sortedPassengerCount.poll();
                System.out.println(passengerCount);
            }
        }
    }

    private PriorityQueue<PassengerCount> toSort(Map<PassengerType, Integer> map) {
        PriorityQueue<PassengerCount> pQueue = new PriorityQueue<>();
        for (Map.Entry<PassengerType, Integer> entry : map.entrySet()) {
            pQueue.add(new PassengerCount(entry.getKey(), entry.getValue()));
        }
        return pQueue;
    }
}
