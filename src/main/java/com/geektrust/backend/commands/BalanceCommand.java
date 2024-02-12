package com.geektrust.backend.commands;

import com.geektrust.backend.services.IMetroCardService;

import java.util.List;

public class BalanceCommand implements ICommand {

    private IMetroCardService metroCardService;

    public BalanceCommand(IMetroCardService metroCardService){
        this.metroCardService=metroCardService;
    }

    @Override
    public void execute(List<String> tokens) {

        String metroCardId=tokens.get(1);
        String balance=tokens.get(2);
        metroCardService.addMetroCard(metroCardId,Integer.parseInt(balance));
    }
}

