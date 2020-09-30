package com.example.corexa.history;

import java.util.ArrayList;
import java.util.List;

public class Historyglobal {
    private final List<History> history;
    private static final Historyglobal ourInstance = new Historyglobal();

    public static Historyglobal getInstance() {

        return ourInstance;
    }

    private Historyglobal() {

        history = new ArrayList<>();
    }

    public List<History> getHistorylistValues() {

        return history;
    }

}
