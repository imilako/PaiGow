package br.com.halyson.materialdesign.gamefragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import br.com.halyson.materialdesign.R;
import br.com.halyson.materialdesign.activity.GameActivity;

/**
 * Created by Ivan on 12.6.2015..
 */
public class SettingsFragment extends Fragment {

    View layout;
    int tileset = 0;
    int Ntileset = 0;
    public void setNewValues () {
        int[] newValues = new int[4];

        //get language
        final Spinner spinner1 = (Spinner) layout.findViewById(R.id.spinner1);
        String selected = spinner1.getSelectedItem().toString();
        if (selected.equals("Hrvatski")) {
            newValues[0] = 1;
        } else {
            newValues[0] = 0;
        }

        //tileset
        newValues[1] = Ntileset;

        //get volume
        final SeekBar sb = (SeekBar) layout.findViewById(R.id.seekbar);
        newValues[2] = sb.getProgress();

        //get mute
        final Switch sw = (Switch) layout.findViewById(R.id.mySwitch);
        if (sw.isChecked()) {
            newValues[3] = 1;
        } else {
            newValues[3] = 0;
        }

        //Toast.makeText(this.getActivity().getBaseContext(), newValues[0] + "" + newValues[1] + "" + newValues[2] + "" + newValues[3] + "", Toast.LENGTH_SHORT).show();
        ((GameActivity) getActivity()).updateSettings(newValues[0],newValues[1],newValues[2],newValues[3]);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Inflate the layout for this fragment
        int[] settings = ((GameActivity) getActivity()).getSettings();

        View toreturn = inflater.inflate(R.layout.fragment_game_settings, container, false);
        layout = toreturn;

        //postavi vrijednost jezika
        final Spinner spinner1 = (Spinner) toreturn.findViewById(R.id.spinner1);
        spinner1.setSelection(((GameActivity) getActivity()).getAPP_LANGUAGE());

        //postavi vrijednost volumena
        final SeekBar sb = (SeekBar) toreturn.findViewById(R.id.seekbar);
        sb.setProgress(settings[2]);

        //postavi vrijednost mute
        final Switch sw = (Switch) toreturn.findViewById(R.id.mySwitch);
        if (settings[3] == 0) {
            sw.setChecked(false);
        } else {
            sw.setChecked(true);
        }

        //postavi tileset
        tileset = settings[1];
        Ntileset = settings[1];

        //language
        sw.setText(((GameActivity) getActivity()).getLangString(15));

        TextView vl = (TextView) toreturn.findViewById(R.id.volumelabel);
        vl.setText(((GameActivity) getActivity()).getLangString(14));

        TextView ll = (TextView) toreturn.findViewById(R.id.languagelabel);
        ll.setText(((GameActivity) getActivity()).getLangString(16));

        TextView ds = (TextView) toreturn.findViewById(R.id.dslabel);
        ds.setText(((GameActivity) getActivity()).getLangString(12));

        Button b = (Button) toreturn.findViewById(R.id.submitS);
        b.setText(((GameActivity) getActivity()).getLangString(24));
        ((Button) b).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                setNewValues();
            }
        });

        ImageView s1 = (ImageView) toreturn.findViewById(R.id.setclassic);
        ((ImageView) s1).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                setTileset(0);
            }
        });

        ImageView s2 = (ImageView) toreturn.findViewById(R.id.setbw);
        ((ImageView) s2).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                setTileset(1);
            }
        });

        return toreturn;
    }

    public void setTileset (int t) {
        if (tileset == t) {
            Toast.makeText(this.getActivity().getBaseContext(), ((GameActivity) getActivity()).getLangString(25), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this.getActivity().getBaseContext(), ((GameActivity) getActivity()).getLangString(26), Toast.LENGTH_SHORT).show();
        }
        Ntileset = t;
    }
}
