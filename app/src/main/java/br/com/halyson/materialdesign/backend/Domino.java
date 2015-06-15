package br.com.halyson.materialdesign.backend;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import br.com.halyson.materialdesign.R;
/**
 * Created by Ivan on 14.6.2015..
 */

public class Domino {
    private final int NUMBER_OF_SETS = 2; //broj setova
    private final int NUMBER_OF_DOMINOES = 32; //broj domina

    private int set = 0; //defaultni - 0
    private int[][] dominoes = new int[NUMBER_OF_SETS][NUMBER_OF_DOMINOES];

    //konstruktor
    public Domino (int set) {
        //postavljanje trenutnog seta
        this.set = set;

        //postavljanje polja
        //int[] myImg = new int[] {R.drawable.set1_1,R.drawable.set1_2};
        dominoes[0][0] = R.drawable.set1_1;
        dominoes[0][1] = R.drawable.set1_2;
        dominoes[0][2] = R.drawable.set1_3;
        dominoes[0][3] = R.drawable.set1_3;
        dominoes[0][4] = R.drawable.set1_4;
        dominoes[0][5] = R.drawable.set1_4;
        dominoes[0][6] = R.drawable.set1_5;
        dominoes[0][7] = R.drawable.set1_5;
        dominoes[0][8] = R.drawable.set1_6;
        dominoes[0][9] = R.drawable.set1_6;
        dominoes[0][10] = R.drawable.set1_7;
        dominoes[0][11] = R.drawable.set1_7;
        dominoes[0][12] = R.drawable.set1_8;
        dominoes[0][13] = R.drawable.set1_8;
        dominoes[0][14] = R.drawable.set1_9;
        dominoes[0][15] = R.drawable.set1_9;
        dominoes[0][16] = R.drawable.set1_10;
        dominoes[0][17] = R.drawable.set1_10;
        dominoes[0][18] = R.drawable.set1_11;
        dominoes[0][19] = R.drawable.set1_11;
        dominoes[0][20] = R.drawable.set1_12;
        dominoes[0][21] = R.drawable.set1_12;
        dominoes[0][22] = R.drawable.set1_13;
        dominoes[0][23] = R.drawable.set1_13;
        dominoes[0][24] = R.drawable.set1_14;
        dominoes[0][25] = R.drawable.set1_15;
        dominoes[0][26] = R.drawable.set1_16;
        dominoes[0][27] = R.drawable.set1_17;
        dominoes[0][28] = R.drawable.set1_18;
        dominoes[0][29] = R.drawable.set1_19;
        dominoes[0][30] = R.drawable.set1_20;
        dominoes[0][31] = R.drawable.set1_21;
        //set2
        dominoes[1][0] = R.drawable.set2_1;
        dominoes[1][1] = R.drawable.set2_2;
        dominoes[1][2] = R.drawable.set2_3;
        dominoes[1][3] = R.drawable.set2_3;
        dominoes[1][4] = R.drawable.set2_4;
        dominoes[1][5] = R.drawable.set2_4;
        dominoes[1][6] = R.drawable.set2_5;
        dominoes[1][7] = R.drawable.set2_5;
        dominoes[1][8] = R.drawable.set2_6;
        dominoes[1][9] = R.drawable.set2_6;
        dominoes[1][10] = R.drawable.set2_7;
        dominoes[1][11] = R.drawable.set2_7;
        dominoes[1][12] = R.drawable.set2_8;
        dominoes[1][13] = R.drawable.set2_8;
        dominoes[1][14] = R.drawable.set2_9;
        dominoes[1][15] = R.drawable.set2_9;
        dominoes[1][16] = R.drawable.set2_10;
        dominoes[1][17] = R.drawable.set2_10;
        dominoes[1][18] = R.drawable.set2_11;
        dominoes[1][19] = R.drawable.set2_11;
        dominoes[1][20] = R.drawable.set2_12;
        dominoes[1][21] = R.drawable.set2_12;
        dominoes[1][22] = R.drawable.set2_13;
        dominoes[1][23] = R.drawable.set2_13;
        dominoes[1][24] = R.drawable.set2_14;
        dominoes[1][25] = R.drawable.set2_15;
        dominoes[1][26] = R.drawable.set2_16;
        dominoes[1][27] = R.drawable.set2_17;
        dominoes[1][28] = R.drawable.set2_18;
        dominoes[1][29] = R.drawable.set2_19;
        dominoes[1][30] = R.drawable.set2_20;
        dominoes[1][31] = R.drawable.set2_21;
    }

    public void setDominoSet (int set) {
        this.set = set;
    }

    public int getDomino (int dominoID) {
        return dominoes[set][dominoID];
    }
}
