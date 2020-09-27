package com.example.corexa.history;

public class Historylist {

    private String nimi;


    public Historylist(String nimi) {

        this.nimi = nimi;

    }

    public String getName(){

        return nimi;

    }


    public String toString(){
        return getName();
    }

}
