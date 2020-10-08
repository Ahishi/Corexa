package com.example.corexa.history;

import androidx.annotation.NonNull;

public class History {

    private final String verensokeriMmol;
    private final String verensokeriMG;
    private final Double hiilihydraatit;
    private final Double insuliinimaara;
    private final String paivamaara;
    private final String ateriatyyppi;

    /**
     *
     * @param verensokeriMmol
     * @param verensokeriMG
     * @param hiilihydraatit
     * @param insuliinimaara
     * @param paivamaara
     * @param ateriatyyppi
     */

    public History(String verensokeriMmol, String verensokeriMG, Double hiilihydraatit, Double insuliinimaara, String paivamaara, String ateriatyyppi) {

        this.verensokeriMmol = verensokeriMmol;
        this.verensokeriMG = verensokeriMG;
        this.hiilihydraatit = hiilihydraatit;
        this.insuliinimaara = insuliinimaara;
        this.paivamaara = paivamaara;
        this.ateriatyyppi = ateriatyyppi;
    }

    public String getVerensokeriMmol(){

        return verensokeriMmol + " mmol/l";

    }

    public String getVerensokeriMG(){

        return verensokeriMG + " mg/dl";

    }

    public String getPaivamaara(){

        return paivamaara;

    }

    public String getAteriatyyppi(){

        return ateriatyyppi;

    }


    public String getHiilihydraatit(){

        return String.valueOf(hiilihydraatit);

    }

    public String getInsuliinimaara(){

        return String.valueOf(insuliinimaara);

    }

    @NonNull
    public String toString(){
        return getAteriatyyppi();
    }
}
