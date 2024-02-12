package com.geektrust.backend.services.impl;

import com.geektrust.backend.entity.MetroCard;
import com.geektrust.backend.exceptions.MetroCardNotFoundException;
import com.geektrust.backend.services.IMetroCardService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MetroCardService implements IMetroCardService {

    Map<String, MetroCard> metroCards = new HashMap<>();
    @Override
    public void addMetroCard(String metroCardId, int balance) {
        MetroCard metroCard=new MetroCard(metroCardId,balance);
        metroCards.put(metroCardId,metroCard);
    }

    @Override
    public MetroCard getMetroCard(String metroCardId) {
        if(metroCards.containsKey(metroCardId))
            return metroCards.get(metroCardId);
        else
            throw new MetroCardNotFoundException("No Such Metro Card Found");
    }

    @Override
    public List<MetroCard> getAllMetroCards() {
        List<MetroCard> cards=new ArrayList<>();
        for(Map.Entry<String,MetroCard> entry : metroCards.entrySet())
            cards.add(entry.getValue());
        return cards;
    }

    @Override
    public int transaction(String metroCardId, int amount) {
        MetroCard metroCard=metroCards.get(metroCardId);
        int balance=metroCard.getBalance();
        int diff=balance-amount;
        if(diff<0){
            metroCard.setBalance(0);
            metroCards.put(metroCardId,metroCard);
            return Math.abs(diff);
        }else{
            metroCard.setBalance(diff);
            metroCards.put(metroCardId,metroCard);
            return -1;
        }
    }


}
