package com.example.corexa.history;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Historyglobal {
    private List<Historylist> Presidents;
    private static final Historyglobal ourInstance = new Historyglobal();

    public static Historyglobal getInstance() {

        return ourInstance;
    }

    private Historyglobal() {

        Presidents = new ArrayList<>();
    }

    public List<Historylist> getHistorylistValues() {

        return Presidents;
    }


}
