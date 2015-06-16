package br.com.halyson.materialdesign.gamefragments;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import br.com.halyson.materialdesign.R;
import br.com.halyson.materialdesign.activity.GameActivity;
import br.com.halyson.materialdesign.backend.Domino;

/**
 * Created by Ivan on 12.6.2015..
 */
public class GameFragment extends Fragment {


    float balance = 0;
    float bet = 0;
    boolean gameon = false;

    View layout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Inflate the layout for this fragment
        final View toreturn = inflater.inflate(R.layout.fragment_game_game, container, false);
        final ImageView dom1 = (ImageView) toreturn.findViewById(R.id.dom1);
        final ImageView dom2 = (ImageView) toreturn.findViewById(R.id.dom2);
        final ImageView dom3 = (ImageView) toreturn.findViewById(R.id.dom3);
        final ImageView dom4 = (ImageView) toreturn.findViewById(R.id.dom4);
        final ImageView dom5 = (ImageView) toreturn.findViewById(R.id.dom5);
        final ImageView dom6 = (ImageView) toreturn.findViewById(R.id.dom6);
        final ImageView dom7 = (ImageView) toreturn.findViewById(R.id.dom7);
        final ImageView dom8 = (ImageView) toreturn.findViewById(R.id.dom8);
        final Button startB = (Button) toreturn.findViewById(R.id.play);
        startB.setText(((GameActivity) getActivity()).getLangString(21));
        final Button assembleB = (Button) toreturn.findViewById(R.id.assemble);
        assembleB.setText(((GameActivity) getActivity()).getLangString(22));
        final Button restartB = (Button) toreturn.findViewById(R.id.restart);
        restartB.setText(((GameActivity) getActivity()).getLangString(23));

        final ImageView c1 = (ImageView) toreturn.findViewById(R.id.c1);
        final ImageView c2 = (ImageView) toreturn.findViewById(R.id.c2);
        final ImageView c3 = (ImageView) toreturn.findViewById(R.id.c3);
        final ImageView c4 = (ImageView) toreturn.findViewById(R.id.c4);

        TextView balanceV = (TextView) toreturn.findViewById(R.id.balance);
        TextView betV = (TextView) toreturn.findViewById(R.id.bet);
        final TextView pair1 = (TextView) toreturn.findViewById(R.id.pair1);
        final TextView pair2 = (TextView) toreturn.findViewById(R.id.pair2);

        pair1.setVisibility(View.GONE);
        pair2.setVisibility(View.GONE);

        float balanceL = ((GameActivity) getActivity()).getBALANCE();
        float betL = 0;

        setGBB(balanceL, betL);

        DecimalFormat df =  new DecimalFormat();
        df.setMaximumFractionDigits(2);
        balanceV.setText(((GameActivity) getActivity()).getLangString(8) + df.format(balance));
        betV.setText(((GameActivity) getActivity()).getLangString(9) + bet);


        SetView(toreturn);



        ((ImageView) dom1).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });

        ((ImageView) dom2).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Drawable tempD = dom2.getDrawable();
                dom2.setImageDrawable(dom1.getDrawable());
                dom1.setImageDrawable(tempD);
                ((GameActivity) getActivity()).modify_PH(1);

            }
        });
        ((ImageView) dom3).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Drawable tempD = dom3.getDrawable();
                dom3.setImageDrawable(dom2.getDrawable());
                dom2.setImageDrawable(dom1.getDrawable());
                dom1.setImageDrawable(tempD);
                ((GameActivity) getActivity()).modify_PH(2);

            }
        });
        ((ImageView) dom4).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Drawable tempD = dom4.getDrawable();
                dom4.setImageDrawable(dom3.getDrawable());
                dom3.setImageDrawable(dom2.getDrawable());
                dom2.setImageDrawable(dom1.getDrawable());
                dom1.setImageDrawable(tempD);
                ((GameActivity) getActivity()).modify_PH(3);

            }
        });

        //start button
        ((Button) startB).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (bet > 0) {
                    gameIsOn();
                    c1.setVisibility(View.GONE);
                    c2.setVisibility(View.GONE);
                    c3.setVisibility(View.GONE);
                    c4.setVisibility(View.GONE);
                    ((GameActivity) getActivity()).restart();
                    int[] player_hand = ((GameActivity) getActivity()).requestDrawHand();
                    Domino domine = new Domino(((GameActivity) getActivity()).getTILESET());
                    startB.setVisibility(View.GONE);
                    assembleB.setVisibility(View.VISIBLE);

                    //Toast.makeText(getActivity().getApplicationContext(), "print:" + player_hand[0] + player_hand[1] + player_hand[2] + player_hand[3], Toast.LENGTH_SHORT).show();

                    dom1.setVisibility(View.VISIBLE);
                    dom2.setVisibility(View.VISIBLE);
                    dom3.setVisibility(View.VISIBLE);
                    dom4.setVisibility(View.VISIBLE);
                    dom1.setImageResource(domine.getDomino(player_hand[0] - 1));
                    dom2.setImageResource(domine.getDomino(player_hand[1] - 1));
                    dom3.setImageResource(domine.getDomino(player_hand[2] - 1));
                    dom4.setImageResource(domine.getDomino(player_hand[3] - 1));
                }

            }
        });

        //assemble button
        ((Button) assembleB).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int[] dealer_hand = ((GameActivity) getActivity()).requestDrawDealerHand();
                Domino domine = new Domino(((GameActivity) getActivity()).getTILESET());
                assembleB.setVisibility(View.GONE);
                restartB.setVisibility(View.VISIBLE);

                //t.makeText( getActivity().getApplicationContext(), "print " + dealer_hand[0] + dealer_hand[1] + dealer_hand[2] + dealer_hand[3], Toast.LENGTH_SHORT ).show();

                dom5.setVisibility(View.VISIBLE);
                dom6.setVisibility(View.VISIBLE);
                dom7.setVisibility(View.VISIBLE);
                dom8.setVisibility(View.VISIBLE);
                dom5.setImageResource(domine.getDomino(dealer_hand[0] - 1));
                dom6.setImageResource(domine.getDomino(dealer_hand[1] - 1));
                dom7.setImageResource(domine.getDomino(dealer_hand[2] - 1));
                dom8.setImageResource(domine.getDomino(dealer_hand[3] - 1));


                int[] win = ((GameActivity) getActivity()).getWinner();
                //Toast.makeText(((GameActivity) getActivity()).getApplicationContext(), "hand 1: " + win[0] + " hand 2: " + win[1] + " game: " + win[2], Toast.LENGTH_SHORT ).show();
                pair1.setVisibility(View.VISIBLE);
                pair2.setVisibility(View.VISIBLE);

                if (win[0] == 1) {
                    pair1.setText(((GameActivity) getActivity()).getLangString(11));
                } else {
                    pair1.setText(((GameActivity) getActivity()).getLangString(10));
                }
                if (win[1] == 1) {
                    pair2.setText(((GameActivity) getActivity()).getLangString(11));
                } else {
                    pair2.setText(((GameActivity) getActivity()).getLangString(10));
                }

                if (win[2] == 0) {
                    float dodaj = (float) (bet*0.95);
                    balance += bet + bet*0.95;
                    bet = 0;
                    //salji na server
                    //Toast.makeText( getActivity().getApplicationContext(), "dodaj = "+ dodaj, Toast.LENGTH_SHORT ).show();
                    ((GameActivity) getActivity()).updateBalance(dodaj);
                } else if (win[2] == 1) {
                    float dodaj = (-bet);
                    bet = 0;
                    //salji na server
                    //Toast.makeText( getActivity().getApplicationContext(), "dodaj = "+ dodaj, Toast.LENGTH_SHORT ).show();
                    ((GameActivity) getActivity()).updateBalance(dodaj);
                } else if (win[2] == 2) {
                    balance += bet;
                    bet = 0;
                }
                BetPlus(0);
            }
        });

        //restart button
        ((Button) restartB).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                gameIsOff();
                c1.setVisibility(View.VISIBLE);
                c2.setVisibility(View.VISIBLE);
                c3.setVisibility(View.VISIBLE);
                c4.setVisibility(View.VISIBLE);
                int[] dealer_hand = ((GameActivity) getActivity()).requestDrawDealerHand();
                Domino domine = new Domino(((GameActivity) getActivity()).getTILESET());
                restartB.setVisibility(View.GONE);
                startB.setVisibility(View.VISIBLE);

                dom1.setVisibility(View.GONE);
                dom2.setVisibility(View.GONE);
                dom3.setVisibility(View.GONE);
                dom4.setVisibility(View.GONE);
                dom5.setVisibility(View.GONE);
                dom6.setVisibility(View.GONE);
                dom7.setVisibility(View.GONE);
                dom8.setVisibility(View.GONE);

                pair1.setVisibility(View.GONE);
                pair2.setVisibility(View.GONE);

                ((GameActivity) getActivity()).restart();

            }
        });


        ////ULOG
        ((ImageView) c1).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                BetPlus(1);
            }
        });

        ((ImageView) c2).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                BetPlus(5);
            }
        });

        ((ImageView) c3).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                BetPlus(25);
            }
        });

        ((ImageView) c4).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                BetPlus(100);
            }
        });

        ((TextView) betV).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                BetClear();
            }
        });

        return toreturn;
    }

    public void setGBB (float balanceL, float betL) {
        this.balance = balanceL;
        this.bet = betL;
    }
    public void BetPlus (int betplus) {
        if (balance >= betplus) {
            balance = balance - betplus;
            bet += betplus;

            TextView balanceV = (TextView) layout.findViewById(R.id.balance);
            TextView betV = (TextView) layout.findViewById(R.id.bet);

            DecimalFormat df =  new DecimalFormat();
            df.setMaximumFractionDigits(2);
            balanceV.setText(((GameActivity) getActivity()).getLangString(8) + df.format(balance));
            betV.setText(((GameActivity) getActivity()).getLangString(9) + bet);

        }
    }

    public void SetView (View toreturn) {
        this.layout = toreturn;

    }

    public void gameIsOn () {
        gameon = true;
    }

    public void gameIsOff () {
        gameon = false;
    }

    public void BetClear () {
        if (gameon == false) {
            TextView balanceV = (TextView) layout.findViewById(R.id.balance);
            TextView betV = (TextView) layout.findViewById(R.id.bet);

            balance += bet;
            bet = 0;

            DecimalFormat df =  new DecimalFormat();
            df.setMaximumFractionDigits(2);
            balanceV.setText(((GameActivity) getActivity()).getLangString(8) + df.format(balance));
            betV.setText(((GameActivity) getActivity()).getLangString(9) + bet);
        }
    }
}
