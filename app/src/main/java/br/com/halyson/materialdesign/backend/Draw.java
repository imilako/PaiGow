package br.com.halyson.materialdesign.backend;

/**
 * Created by Ivan on 14.6.2015..
 */
import java.util.ArrayList;
import java.util.Random;


public class Draw {

    private ArrayList<Integer> deck = new ArrayList<Integer>();

    public Draw () {
        reset();
    }

    public int getDomino () {
        Random r = new Random();
        int Low = 0;
        int High = deck.size();
        int R = r.nextInt(High - Low) + Low;
        int value = deck.get(R);
        deck.remove(R);
        System.out.println(value);
        return value;
    }

    public void reset () {
        deck.clear();
        for ( int i = 1; i < 33; i++ ) {
            deck.add(i);
        }
    }
}
