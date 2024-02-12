package com.geektrust.backend.commands;

import com.geektrust.backend.entity.PassengerCheckIn;
import com.geektrust.backend.entity.PassengerType;
import com.geektrust.backend.entity.Station;
import com.geektrust.backend.services.ICheckInService;

import java.util.List;

public class CheckInCommand implements ICommand{

    ICheckInService checkInService;

    public CheckInCommand(ICheckInService checkInService){
        this.checkInService=checkInService;
    }
    @Override
    public void execute(List<String> tokens) {
        String metroCardId= tokens.get(1);
        String passengerType=tokens.get(2);
        String boardingStation=tokens.get(3);
        checkInService.checkInPassenger(new PassengerCheckIn(metroCardId,PassengerType.valueOf(passengerType),Station.valueOf(boardingStation)));
    }
}
