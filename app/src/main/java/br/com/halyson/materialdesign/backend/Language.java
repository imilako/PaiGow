package br.com.halyson.materialdesign.backend;

/**
 * Created by Ivan on 14.6.2015..
 */

public class Language {
    private final int NUMBER_OF_LANGUAGES = 2; //broj jezika u polju
    private final int NUMBER_OF_STRINGS = 21; //broj stringova u polju

    private int language = 0; //defaultni eng - 0 ili hrv - 1
    private String[][] strings = new String[NUMBER_OF_LANGUAGES][NUMBER_OF_STRINGS];

    //konstruktor
    public Language (int language) {
        this.language = language;

        //postavljanje polja
        strings[0][0] = "Game";
        strings[0][1] = "Store";
        strings[0][2] = "Buy credit and more!";
        strings[0][3] = "Settings";
        strings[0][4] = "Customise your PaiGow app!";
        strings[0][5] = "About";
        strings[0][6] = "Additional info andd rules!";
        strings[0][7] = "Logout";
        strings[0][8] = "";
        strings[0][9] = "";
        strings[0][10] = "";
        strings[0][11] = "";
        strings[0][12] = "";
        strings[0][13] = "";
        strings[0][14] = "";
        strings[0][15] = "";
        strings[0][16] = "";
        strings[0][17] = "";
        strings[0][18] = "";
        strings[0][19] = "";
        strings[0][20] = "";

        strings[1][0] = "Igra";
        strings[1][1] = "Trgovina";
        strings[1][2] = "Dodajte novac u aplikaciju!";
        strings[1][3] = "Postavke";
        strings[1][4] = "Uredite Vasu aplikaciju";
        strings[1][5] = "Info";
        strings[1][6] = "Informacije i upute!";
        strings[1][7] = "Odjava";
    }

    public void setLanguage (int language) {
        this.language = language;
    }//??????

    public String getLangString (int stringID) {
        return strings[language][stringID];
    }
}

