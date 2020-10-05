package com.example.corexa.history;

import androidx.annotation.NonNull;

public class History {

    private final String verensokeriMmol;
    private final String verensokeriMG;
    private final int hiilihydraatit;
    private final int insuliinimaara;
    private final String nimi;
    private final String paivamaara;
    private final String ateriatyyppi;

    public History(String verensokeriMmol, String verensokeriMG, int hiilihydraatit, int insuliinimaara, String nimi, String paivamaara, String ateriatyyppi) {

        this.verensokeriMmol = verensokeriMmol;
        this.verensokeriMG = verensokeriMG;
        this.hiilihydraatit = hiilihydraatit;
        this.insuliinimaara = insuliinimaara;
        this.nimi = nimi;
        this.paivamaara = paivamaara;
        this.ateriatyyppi = ateriatyyppi;
    }

    public String getVerensokeriMmol(){

        return String.valueOf(verensokeriMmol) + " mmol/l";

    }

    public String getVerensokeriMG(){

        return String.valueOf(verensokeriMG) + " mg/dl";

    }

    public String getPaivamaara(){

        return paivamaara;

    }

    public String getAteriatyyppi(){

        return ateriatyyppi;

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
