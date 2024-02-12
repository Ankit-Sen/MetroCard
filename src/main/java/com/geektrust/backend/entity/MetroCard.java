package com.geektrust.backend.entity;

public class MetroCard{

    private String metroCardId;
    private int balance;
    public MetroCard() {
    }

    public MetroCard(String metroCardId, Integer balance) {
        this.metroCardId = metroCardId;
        this.balance = balance;
    }

    public void setmetroCardId(String metroCardId) {
        this.metroCardId = metroCardId;
    }

    public String getMetroCardId() { return this.metroCardId; }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((metroCardId == null) ? 0 : metroCardId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MetroCard other = (MetroCard) obj;
        if (metroCardId == null) {
            if (other.metroCardId != null)
                return false;
        } else if (!metroCardId.equals(other.metroCardId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "MetroCard{" +
                "metroCardId='" + metroCardId + '\'' +
                ", balance=" + balance +
                '}';
    }
}
