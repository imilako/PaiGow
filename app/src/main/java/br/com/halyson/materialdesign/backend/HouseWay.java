package br.com.halyson.materialdesign.backend;

/**
 * Created by Ivan on 14.6.2015..
 */

public class HouseWay {
    private int dealer_domino_1;
    private int dealer_domino_2;
    private int dealer_domino_3;
    private int dealer_domino_4;
    private int dealer_hand_1;
    private int dealer_hand_2;
    private int[] values = new int[32];
    private int [] rang = new int [32];

    //konstruktor
    public void Calculate () {
        values[0] = 3;
        values[1] = 6;
        values[2] = 12;
        values[3] = 12;
        values[4] = 2;
        values[5] = 2;
        values[6] = 8;
        values[7] = 8;
        values[8] = 4;
        values[9] = 4;
        values[10] = 10;
        values[11] = 10;
        values[12] = 6;
        values[13] = 6;
        values[14] = 4;
        values[15] = 4;
        values[16] = 11;
        values[17] = 11;
        values[18] = 10;
        values[19] = 10;
        values[20] = 7;
        values[21] = 7;
        values[22] = 6;
        values[23] = 6;
        values[24] = 9;
        values[25] = 9;
        values[26] = 8;
        values[27] = 8;
        values[28] = 7;
        values[29] = 7;
        values[30] = 5;
        values[31] = 5;
        rang[0] = 33;
        rang[1] = 33;
        rang[2] = 2;
        rang[3] = 2;
        rang[4] = 3;
        rang[5] = 3;
        rang[6] = 4;
        rang[7] = 4;
        rang[8] = 5;
        rang[9] = 5;
        rang[10] = 6;
        rang[11] = 6;
        rang[12] = 7;
        rang[13] = 7;
        rang[14] = 8;
        rang[15] = 8;
        rang[16] = 9;
        rang[17] = 9;
        rang[18] = 10;
        rang[19] = 10;
        rang[20] = 11;
        rang[21] = 11;
        rang[22] = 12;
        rang[23] = 12;
        rang[24] = 13;
        rang[25] = 13;
        rang[26] = 14;
        rang[27] = 14;
        rang[28] = 15;
        rang[29] = 15;
        rang[30] = 16;
        rang[31] = 16;

    }
    public int [] arrangeTiles (int dealer_domino_1, int dealer_domino_2, int dealer_domino_3, int dealer_domino_4) {
        int [] tiles=new int[4];
        if (isPair (dealer_domino_1, dealer_domino_2) > 0) {
            tiles[0]=dealer_domino_3;
            tiles[1]=dealer_domino_4;
            tiles[2]=dealer_domino_1;
            tiles[3]=dealer_domino_2;
            return tiles;
        } else if (isPair(dealer_domino_1,dealer_domino_3) > 0) {
            tiles[0]=dealer_domino_2;
            tiles[1]=dealer_domino_4;
            tiles[2]=dealer_domino_1;
            tiles[3]=dealer_domino_3;
            return tiles;
        } else if (isPair(dealer_domino_1,dealer_domino_4) > 0) {
            tiles[0]=dealer_domino_2;
            tiles[1]=dealer_domino_3;
            tiles[2]=dealer_domino_1;
            tiles[3]=dealer_domino_4;
            return tiles;
        } else if (isPair(dealer_domino_2,dealer_domino_3) > 0) {
            tiles[0]=dealer_domino_1;
            tiles[1]=dealer_domino_4;
            tiles[2]=dealer_domino_2;
            tiles[3]=dealer_domino_3;
            return tiles;
        } else if (isPair(dealer_domino_3,dealer_domino_4) > 0) {
            tiles[0]=dealer_domino_1;
            tiles[1]=dealer_domino_2;
            tiles[2]=dealer_domino_3;
            tiles[3]=dealer_domino_4;
            return tiles;
        } else if (isPair(dealer_domino_2,dealer_domino_4) > 0) {
            tiles[0]=dealer_domino_1;
            tiles[1]=dealer_domino_3;
            tiles[2]=dealer_domino_2;
            tiles[3]=dealer_domino_4;
            return tiles;
        }

        int [] first_comb = new int[2];
        int [] second_comb = new int[2];
        int [] third_comb = new int[2];


        first_comb=calculateDealerHand(dealer_domino_1,dealer_domino_2,dealer_domino_3,dealer_domino_4);
        second_comb=calculateDealerHand(dealer_domino_1,dealer_domino_3,dealer_domino_2,dealer_domino_4);
        third_comb=calculateDealerHand(dealer_domino_1,dealer_domino_4,dealer_domino_2,dealer_domino_3);

        int first_min= (first_comb[0]<first_comb[1] ? first_comb[0] : first_comb[1]);
        int second_min= (second_comb[0]<second_comb[1] ? second_comb[0] : second_comb[1]);
        int third_min= (third_comb[0]<third_comb[1] ? third_comb[0] : third_comb[1]);

        int first_max= (first_comb[0]>first_comb[1] ? first_comb[0] : first_comb[1]);
        int second_max= (second_comb[0]>second_comb[1] ? second_comb[0] : second_comb[1]);
        int third_max= (third_comb[0]>third_comb[1] ? third_comb[0] : third_comb[1]);

        if (first_min > second_min && first_min>third_min) {
            tiles[0]=dealer_domino_1;
            tiles[1]=dealer_domino_3;
            tiles[2]=dealer_domino_2;
            tiles[3]=dealer_domino_4;
            return tiles;
        } else if (second_min > first_min && second_min>third_min) {
            tiles[0]=dealer_domino_1;
            tiles[1]=dealer_domino_3;
            tiles[2]=dealer_domino_2;
            tiles[3]=dealer_domino_4;
            return tiles;
        } else if (third_min > first_min && third_min>second_min){
            tiles[0]=dealer_domino_1;
            tiles[1]=dealer_domino_4;
            tiles[2]=dealer_domino_2;
            tiles[3]=dealer_domino_3;
            return tiles;
        } else if (first_min==second_min && first_min>third_min) {
            if (first_max>=second_max) {
                tiles[0]=dealer_domino_1;
                tiles[1]=dealer_domino_3;
                tiles[2]=dealer_domino_2;
                tiles[3]=dealer_domino_4;
                return tiles;
            } else {
                tiles[0]=dealer_domino_1;
                tiles[1]=dealer_domino_3;
                tiles[2]=dealer_domino_2;
                tiles[3]=dealer_domino_4;
                return tiles;
            }
        } else if (second_min==third_min && third_min>first_min) {
            if (second_max>=third_max) {
                tiles[0]=dealer_domino_1;
                tiles[1]=dealer_domino_3;
                tiles[2]=dealer_domino_2;
                tiles[3]=dealer_domino_4;
                return tiles;
            } else {
                tiles[0]=dealer_domino_1;
                tiles[1]=dealer_domino_4;
                tiles[2]=dealer_domino_2;
                tiles[3]=dealer_domino_3;
                return tiles;
            }
        } else if (first_min==third_min && first_min>second_min) {
            if (first_max>=third_max) {
                tiles[0]=dealer_domino_1;
                tiles[1]=dealer_domino_3;
                tiles[2]=dealer_domino_2;
                tiles[3]=dealer_domino_4;
                return tiles;
            } else {
                tiles[0]=dealer_domino_1;
                tiles[1]=dealer_domino_4;
                tiles[2]=dealer_domino_2;
                tiles[3]=dealer_domino_3;
                return tiles;
            }
        }
        return tiles;
    }

    private int isPair(int dom1, int dom2) {
        if ((dom1 == 1 && dom2 == 2) || (dom1 == 2 && dom2 == 1)) {
            return 1;
        } else if ((dom1 == 3 && dom2 == 4)|| (dom1 == 4 && dom2 == 3)) {
            return 2;
        } else if ((dom1 == 5 && dom2 == 6) || (dom1 == 6 && dom2 == 5)) {
            return 3;
        } else if ((dom1 == 7 && dom2 == 8) || (dom1 == 8 && dom2 == 7)){
            return 4;
        } else if ((dom1 == 9 && dom2 == 10) || (dom1 == 10 && dom2 == 9)) {
            return 5;
        } else if ((dom1 == 11 && dom2 == 12) || (dom1 == 12 && dom2 == 11)) {
            return 6;
        } else if ((dom1 == 13 && dom2 == 14) || (dom1 == 14 && dom2 == 13)) {
            return 7;
        } else if ((dom1 == 15 && dom2 == 16) || (dom1 == 16 && dom2 == 15)){
            return 8;
        } else if ((dom1 == 17 && dom2 == 18) || (dom1 == 18 && dom2 == 17)) {
            return 9;
        } else if ((dom1 == 19 && dom2 == 20) || (dom1 == 20 && dom2 == 19)) {
            return 10;
        } else if ((dom1 == 21 && dom2 == 22) || (dom1 == 22 && dom2 == 21)){
            return 11;
        } else if ((dom1 == 23 && dom2 == 24) || (dom1 == 24 && dom2 == 23)) {
            return 12;
        } else if ((dom1 == 25 && dom2 == 26) || (dom1 == 26 && dom2 == 25)){
            return 13;
        } else if ((dom1 == 27 && dom2 == 28) || (dom1 == 28 && dom2 == 27)){
            return 14;
        } else if ((dom1 == 29 && dom2 == 30) || (dom1 == 30 && dom2 == 29)){
            return 15;
        } else if ((dom1 == 31 && dom2 == 32) || (dom1 == 32 && dom2 == 31)) {
            return 16;
        }
        return 0;
    }

    private int [] calculateDealerHand (int dealer_domino_1,int dealer_domino_2,int dealer_domino_3,int dealer_domino_4) {
        //prva ruka
        int [] dealer_hand=new int[2];
        dealer_hand[0] = values[dealer_domino_1-1];
        dealer_hand[0] += values[dealer_domino_2-1];

        //wild domino gong joon check (3 ili 6) HAND 1
        if (dealer_domino_1 == 1 || dealer_domino_2 == 1) {
            if (lastDigit(dealer_hand[0]) < lastDigit(dealer_hand[0]+3)) {
                dealer_hand[0] += 3;
            }
        }
        if (dealer_domino_1 == 2 || dealer_domino_2 == 2) {
            if (lastDigit(dealer_hand[0]) < lastDigit(dealer_hand[0]-3)) {
                dealer_hand[0] -= 3;
            }
        }

        //zaokruzi
        dealer_hand[0] = lastDigit(dealer_hand[0]);

        //gong check
        if ( (dealer_domino_1 == 3 || dealer_domino_1 == 4 || dealer_domino_1 == 5 || dealer_domino_1 == 6  ) && (dealer_domino_2 == 27 || dealer_domino_2 == 28) ) {
            dealer_hand[0] = 10;
        }
        if ( (dealer_domino_2 == 3 || dealer_domino_2 == 4 || dealer_domino_2 == 5 || dealer_domino_2 == 6  ) && (dealer_domino_1 == 27 || dealer_domino_1 == 28) ) {
            dealer_hand[0] = 10;
        }

        //wong check
        if ( (dealer_domino_1 == 3 || dealer_domino_1 == 4 || dealer_domino_1 == 5 || dealer_domino_1 == 6  ) && (dealer_domino_2 == 25 || dealer_domino_2 == 26) ) {
            dealer_hand[0] = 11;
        }
        if ( (dealer_domino_2 == 3 || dealer_domino_2 == 4 || dealer_domino_2 == 5 || dealer_domino_2 == 6  ) && (dealer_domino_1 == 25 || dealer_domino_1 == 26) ) {
            dealer_hand[0] = 11;
        }


        //druga ruka

        dealer_hand[1] = values[dealer_domino_3-1];
        dealer_hand[1] += values[dealer_domino_4-1];

        //wild domino gong joon check (3 ili 6) HAND 2
        if (dealer_domino_3 == 1 || dealer_domino_4 == 1) {
            if (lastDigit(dealer_hand[1]) < lastDigit(dealer_hand[1]+3)) {
                dealer_hand[1] += 3;
            }
        }
        if (dealer_domino_3 == 2 || dealer_domino_4 == 2) {
            if (lastDigit(dealer_hand[1]) < lastDigit(dealer_hand[1]-3)) {
                dealer_hand[1] -= 3;
            }
        }

        //zaokruzi
        dealer_hand[1] = lastDigit(dealer_hand[1]);

        //gong check
        if ( (dealer_domino_3 == 3 || dealer_domino_3 == 4 || dealer_domino_3 == 5 || dealer_domino_3 == 6  ) && (dealer_domino_4 == 27 || dealer_domino_4 == 28) ) {
            dealer_hand[1] = 10;
        }
        if ( (dealer_domino_4 == 3 || dealer_domino_4 == 4 || dealer_domino_4 == 5 || dealer_domino_4 == 6  ) && (dealer_domino_3 == 27 || dealer_domino_3 == 28) ) {
            dealer_hand[1] = 10;
        }

        //wong check
        if ( (dealer_domino_3 == 3 || dealer_domino_3 == 4 || dealer_domino_3 == 5 || dealer_domino_3 == 6  ) && (dealer_domino_4 == 25 || dealer_domino_4 == 26) ) {
            dealer_hand[1] = 11;
        }
        if ( (dealer_domino_4 == 3 || dealer_domino_4 == 4 || dealer_domino_4 == 5 || dealer_domino_4 == 6  ) && (dealer_domino_3 == 25 || dealer_domino_3 == 26) ) {
            dealer_hand[1] = 11;
        }

        return dealer_hand;

    }

    private int lastDigit (int number) {
        return number % 10;
    }

}
