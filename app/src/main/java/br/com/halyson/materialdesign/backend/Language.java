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
        strings[0][8] = "Balance: $";
        strings[0][9] = "Bet: $";
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
        strings[0][20] = "Are you sure you want to buy $";
        strings[0][21] = "Play";
        strings[0][22] = "Continue";
        strings[0][23] = "New game";
        strings[0][24] = "Submit";
        strings[0][25] = "This tile set is already active!";
        strings[0][26] = "Press submit to activate this tileset!";
        strings[0][27] = "Pai gow is the oldest of the casino games. It easily pre-dates roulette and baccarat. Pai gow is a difficult game to learn, what makes pai gow difficult is that the order of hands and tiles seems largely random, and is difficult to memorize. Following are the primary rules when it comes to pai gow. In case the player wins, he will win back his bet plus the bet reduced for 5% comission.";
        strings[0][28] = "Pai gow is played with a set of 32 dominoes.\n\nEach player and dealer will be given four tiles.\nThe player will separate his tiles into low and high hands. The player does not need to specify which is higher, as this will be obvious.\n\nEach pair of tiles will have a ranking order as follows:\n\nPair: There are 16 pairs, 11 identical and 5 mixed pairs.\n\nWong: This is a 2 or 12 tile with any 9 tile.\n\nGong: This is a 2 or 12 tile with any 8 tile.\n\n9 to 0 points (the more the better): For all other 2-tile hands, the total number of dots will be taken, and the terminal digit is used to determine the number of points (as in baccarat).\n\nFor example, a 10 and 9 tile is worth 9 points; a 4 and 7 tile is worth 1 point.\n\nAn exception to the above rule is that the two tiles in the highest ranking Gee Joon pair are semi-wild and are worth either 3 or 6 points,whichever results in a higher total. For example, when combined with a 4-point tile, a Gee Joon tile counts as 3 points to make a 7-point hand, instead of counting as 6 points to make a 0-point hand.\n\nThe player's high hand will be compared to the dealer's high hand, and the player's low hand compared to the dealer's low hand (as in pai gow poker).\nIf both player and dealer have a Wong, Gong, or 1 to 9 points, the tie will be broken according to which hand has the higher-ranked high tile.\nIf the high tile does not break the tie then the win will go to the banker.\nA 0-0 tie always goes to the banker.\nWhen using high tiles to break a tie, the rank order is the same as the pair order, except the two tiles in the highest gee joon pair are ranked lowest individually and will therefore never be a hand's high tile.\n\nIf the player wins both hands he will win even money, less a 5% commission. If the player wins one and loses one then his wager will push. If the dealer wins both then the player will lose his wager.\n\n\nDino Ivan Natali\nWe are a young team of students. We like to play  games. We like to code. We like Android.\nEnrolled in the 1st year of Computer Master's study in Tehnicki fakultet Rijeka.";

        strings[1][0] = "Igra";
        strings[1][1] = "Trgovina";
        strings[1][2] = "Dodajte novac u aplikaciju!";
        strings[1][3] = "Postavke";
        strings[1][4] = "Uredite Vasu aplikaciju";
        strings[1][5] = "Info";
        strings[1][6] = "Informacije i upute!";
        strings[1][7] = "Odjava";
        strings[1][8] = "Stanje: $";
        strings[1][9] = "Ulog: $";
        strings[1][10] = "WIN";
        strings[1][11] = "LOSS";
        strings[1][12] = "Domino izgled:";
        strings[1][13] = "Novac:";
        strings[1][14] = "Glasnoca";
        strings[1][15] = "Bez zvuka";
        strings[1][16] = "Jezik";
        strings[1][17] = "Domino izgled";
        strings[1][18] = "Vec posjedujete ovaj set!";
        strings[1][19] = "Potvrdite kupnju";
        strings[1][20] = "Jeste li sigurni da zelite kupiti $";
        strings[1][21] = "Igraj";
        strings[1][22] = "Nastavi";
        strings[1][23] = "Nova igra";
        strings[1][24] = "Spremi";
        strings[1][25] = "Ovaj set je vec aktivan!";
        strings[1][26] = "Pritisnite Spremi za aktivaciju!";
        strings[1][27] = "Pai gow je jedna od najstarijih casino igra. Nastala je prije ruleta i bakarata. Pai gow je slozena igra za nauciti, i to zbog redoslijeda ruku i domina koje se cine slucajnim te ih je tesko zapamtiti.\nU nastavku su osnovna pravila pai gowa. U slucaju pobjede igraca, dobiva natrag svoj ulog plus ulog umanjen za 5% provizije.";
        strings[1][28] = "Pai gow se igra sa setom od 32 domine.\n\nSvaki igrac dobije 4 domine.\nIgrac zatim grupira domine u \"manju\" i \"vecu\" ruku. Nije potrebno eksplicitno naglasiti koja je koja, nego je to ocito.\nSvaki par domina ce biti evaluiran na ovaj nacin:\nParovi: Postoji 16 parova, 11 identicni i 5 mijesanih parova\nWong: Vrijednost ove domine je 2 ili 12 s bilo kojom devetkom\nGong: Vrijednost ove domine je 2 ili 12 s bilo kojom osmicom\n9 do 0 (sto vise to bolje): za sve ostale parove domina, uzima se broj tocaka na njima i gledamo zadnju znamenku. Npr. 10 i 9 domine skupa vrijede 9c 4 i 7 domine vrijede 1 bod.\nIznimka za gore navedeno pravilo jest da dvije domine s najvecim rangom \"Gee Joon\" vrijede ili 3 ili 6 bodova, ovisno s kojom vrijednosti ce rezultat doc veci. Npr. u kombinaciji s dominom vrijednosti 4, Gee Joon se uzima kao 3 da se dobije rezultat 7, umjesto da se uzme kao 6 sto bi rezultiralo nulom u konacnici.\nIgraceva \"veca\" ruka se usporeduje s dealerovom \"vecom\" rukom, a igraceva \"manja\" ruka se usporeduje s dealerovom \"manjom\" rukom. Ako dode do izjednacenja, pobjeduje osoba cija je domina vise rangirana. Ako je i najjaca domina ista, pobjeda ide bankaru (dealeru). Kada se gleda koja je domina jace rangirana koristimo isti poredak parova kao ranije, iznimka je Gee Joon par, koju su najslabiji kad ih se gleda zasebno.\nAko obe ruke igraca pobijede, on dobiva novac, umanjen za 5% provizije. Ako jedna igraceva ruka pobijedi, a druga izgubi to nazivamo \"push\". Kada dealer pobijedi to znaci da je igrac izgubio u obje ruke.\n\nDino Ivan Natali\nMi smo grupa studenata. Volimo igrice. Volimo programirati. Volimo Android.\nTrenutno upisani na 1 godinu diplomskog studija racunarstva na Tehnickom fakultetu Rijeka.";
    }

    public void setLanguage (int language) {
        this.language = language;
    }//??????

    public String getLangString (int stringID) {
        return strings[language][stringID];
    }
}

