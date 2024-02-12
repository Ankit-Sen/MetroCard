package com.geektrust.backend.services;

import com.geektrust.backend.entity.MetroCard;

import java.util.List;

public interface IMetroCardService {

    public void addMetroCard(String metroCardId, int balance);
    public MetroCard getMetroCard(String metroCardId);
    public List<MetroCard> getAllMetroCards();
    public int transaction(String metroCardId,int amount);
}
