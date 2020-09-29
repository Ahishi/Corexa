package com.example.corexa.history;

import androidx.annotation.NonNull;

public class Historylist {
    private final String nimi;


    public Historylist(String nimi) {

        this.nimi = nimi;

    }

    public String getName(){

        return nimi;

    }

    @NonNull
    public String toString(){
        return getName();
    }
}
