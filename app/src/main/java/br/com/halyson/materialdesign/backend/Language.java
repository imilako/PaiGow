package br.com.halyson.materialdesign.backend;

/**
 * Created by Ivan on 14.6.2015..
 */

public class Language {
    private final int NUMBER_OF_LANGUAGES = 2; //broj jezika u polju
    private final int NUMBER_OF_STRINGS = 100; //broj stringova u polju

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
        strings[0][8] = "Balance: ";
        strings[0][9] = "Bet: ";
        strings[0][10] = "WIN";
        strings[0][11] = "LOSS";
        strings[0][12] = "Domino skins:";
        strings[0][13] = "Credit:";
        strings[0][14] = "Volume";
        strings[0][15] = "Mute";
        strings[0][16] = "Language";
        strings[0][17] = "Domino skins";
        strings[0][18] = "You already own this tile set!";
        strings[0][19] = "Confirm purchase";
        strings[0][20] = "Are you sure you want to buy ";
        strings[0][21] = "PLAY";
        strings[0][22] = "CONTINUE";
        strings[0][23] = "NEW GAME";
        strings[0][24] = "SUBMIT";
        strings[0][25] = "This tile set is already active!";
        strings[0][26] = "Press submit to activate this tileset!";

        strings[1][0] = "Igra";
        strings[1][1] = "Trgovina";
        strings[1][2] = "Dodajte novac u aplikaciju!";
        strings[1][3] = "Postavke";
        strings[1][4] = "Uredite Vasu aplikaciju";
        strings[1][5] = "Info";
        strings[1][6] = "Informacije i upute!";
        strings[1][7] = "Odjava";
        strings[1][8] = "Stanje: ";
        strings[1][9] = "Ulog: ";
        strings[1][10] = "POBJEDA";
        strings[1][11] = "GUBITAK";
        strings[1][12] = "Domino izgled:";
        strings[1][13] = "Novac:";
        strings[1][14] = "Glasnoca";
        strings[1][15] = "Bez zvuka";
        strings[1][16] = "Jezik";
        strings[1][17] = "Domino izgled";
        strings[1][18] = "Vec posjedujete ovaj set!";
        strings[1][19] = "Potvrdite kupnju";
        strings[1][20] = "Jeste li sigurni da zelite kupiti ";
        strings[1][21] = "IGRAJ";
        strings[1][22] = "NASTAVI";
        strings[1][23] = "NOVA IGRA";
        strings[1][24] = "SPREMI";
        strings[1][25] = "Ovaj set je vec aktivan!";
        strings[1][26] = "Pritisnite Spremi za aktivaciju!";
    }

    public void setLanguage (int language) {
        this.language = language;
    }//??????

    public String getLangString (int stringID) {
        return strings[language][stringID];
    }
}

