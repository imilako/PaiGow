package br.com.halyson.materialdesign.gamefragments;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import br.com.halyson.materialdesign.R;
import br.com.halyson.materialdesign.activity.GameActivity;

/**
 * Created by Ivan on 12.6.2015..
 */
public class StoreFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_game_store, container, false);

        final ImageView buy1 = (ImageView) layout.findViewById(R.id.buy1);
        final ImageView buy5 = (ImageView) layout.findViewById(R.id.buy5);
        final ImageView buy25 = (ImageView) layout.findViewById(R.id.buy25);
        final ImageView buy100 = (ImageView) layout.findViewById(R.id.buy100);
        final ImageView buyc = (ImageView) layout.findViewById(R.id.buyclassic);
        final ImageView buybw = (ImageView) layout.findViewById(R.id.buybw);

        ((ImageView) buy1).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                buyCredit(1);
            }
        });

        ((ImageView) buy5).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                buyCredit(5);
            }
        });

        ((ImageView) buy25).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                buyCredit(25);
            }
        });

        ((ImageView) buy100).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                buyCredit(100);
            }
        });

        ((ImageView) buyc).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String messageY = ((GameActivity) getActivity()).getLangString(18);
                Toast.makeText( getActivity().getApplicationContext(), messageY, Toast.LENGTH_SHORT ).show();
            }
        });
        ((ImageView) buybw).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String messageY = ((GameActivity) getActivity()).getLangString(18);
                Toast.makeText( getActivity().getApplicationContext(), messageY, Toast.LENGTH_SHORT ).show();

            }
        });

        //language
        TextView ds = (TextView) layout.findViewById(R.id.dominoskins);
        ds.setText(((GameActivity) getActivity()).getLangString(12));

        TextView cl = (TextView) layout.findViewById(R.id.creditlabel);
        cl.setText(((GameActivity) getActivity()).getLangString(13));

        return layout;
    }

    public void buyCredit (final float toAdd) {
        String messageC = ((GameActivity) getActivity()).getLangString(19);
        String messageA = ((GameActivity) getActivity()).getLangString(20);
        new AlertDialog.Builder(getActivity())
                .setTitle(messageC)
                .setMessage(messageA + toAdd + "?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        ((GameActivity) getActivity()).updateBalance(toAdd);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}
