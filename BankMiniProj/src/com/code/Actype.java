package com.code;

public enum Actype {

    SAVINGACCOUNT(1000),CURRENTACCOUNT(50000),DEMATACCOUNT(10000);

    private double minBalance;

    private Actype(double minBalance){
        this.minBalance=minBalance;
    }

    public double getMinBal(){
        return minBalance;
    }

    public void setMinBal(double newBal){
        minBalance=newBal;
    }
}
