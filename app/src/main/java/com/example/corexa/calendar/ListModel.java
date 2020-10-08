package com.example.corexa.calendar;

public class ListModel {
    private String type;
    private String verensokeri;
    private String hiilihydraatti;
    private String insuliini;

    public ListModel(String type, String verensokeri, String hiilihydraatti, String insuliini){
        this.type = type;
        this.verensokeri = verensokeri;
        this.hiilihydraatti = hiilihydraatti;
        this.insuliini = insuliini;
    }

    public String getType(){
        return type;
    }

    public String getVerensokeri(){
        return verensokeri;
    }

    public String getHiilihydraatti() {
        return hiilihydraatti;
    }

    public String getInsuliini() {
        return insuliini;
    }
}
