package com.code;

import java.io.Serializable;

public class Address implements Serializable{

    private String city;
    private String state;
    private String country;



    public Address(String city,String state,String country){
        this.city=city;
        this.state=state;
        this.country=country;
    }


    public String getCity(){
        return city;
    }

    
    public String getState(){
        return state;
    }
    
    public String getCountry(){
        return country;
    }


    @Override
    public String toString() {
        return "Address [city=" + city + ", state=" + state + ", country=" + country + "]";
    }

    
}
