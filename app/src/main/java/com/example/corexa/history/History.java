package com.example.corexa.history;

import androidx.annotation.NonNull;

public class History {
    private final int verensokeri;
    private final int hiilihydraatit;
    private final int insuliinimaara;
    private final String nimi;
    private final String paivamaara;

    public History(int verensokeri, int hiilihydraatit, int insuliinimaara, String nimi, String paivamaara) {

        this.verensokeri = verensokeri;
        this.hiilihydraatit = hiilihydraatit;
        this.insuliinimaara = insuliinimaara;
        this.nimi = nimi;
        this.paivamaara = paivamaara;
    }

    public String getVerensokeri(){

        return Integer.toString(verensokeri);

    }

    public String getPaivamaara(){

        return paivamaara;

    }

    public String getNimi(){

        return nimi;

    }

    public String getHiilihydraatit(){

        return Integer.toString(hiilihydraatit);

    }

    public String getInsuliinimaara(){

        return Integer.toString(insuliinimaara);

    }

    @NonNull
    public String toString(){
        return getNimi();
    }
}
