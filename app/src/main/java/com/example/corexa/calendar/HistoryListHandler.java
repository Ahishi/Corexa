package com.example.corexa.calendar;

import com.example.corexa.history.History;

import java.util.ArrayList;
import java.util.List;

public class HistoryListHandler {

    private List<ListModel> returnlist = new ArrayList<>();;
    List<History> historyList;

    public HistoryListHandler(List<History> historyList){
        this.historyList = historyList;
    }

    public List<ListModel> getModelForList(){

        for(int i = 0; i < historyList.size(); i++){
            this.returnlist.add(new ListModel(historyList.get(i).getAteriatyyppi(), historyList.get(i).getVerensokeriMG(), historyList.get(i).getHiilihydraatit(), historyList.get(i).getInsuliinimaara()));
        }

        return this.returnlist;
    }

    public int getDays(){
        int days = 1;

        String str = historyList.get(0).getPaivamaara();
        String prevStr = historyList.get(0).getPaivamaara();

        for(int i = 0; i < historyList.size(); i++){
            str = historyList.get(i).getPaivamaara();
            if(str.charAt(8) != prevStr.charAt(8)){
                prevStr = historyList.get(i).getPaivamaara();
            }
        }
        return days;
    }

}
