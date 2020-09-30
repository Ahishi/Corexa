package com.example.corexa.history;

import androidx.annotation.NonNull;

public class History {
    private final String nimi;
    private final String info;


    public History(String nimi, String info) {

        this.nimi = nimi;
        this.info = info;
    }

    public String getName(){

        return nimi;

    }

    public String getInfo(){

        return info;

    }



    @NonNull
    public String toString(){
        return getName();
    }
}
