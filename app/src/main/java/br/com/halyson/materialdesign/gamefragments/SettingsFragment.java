package br.com.halyson.materialdesign.gamefragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import br.com.halyson.materialdesign.R;
import br.com.halyson.materialdesign.activity.GameActivity;

/**
 * Created by Ivan on 12.6.2015..
 */
public class SettingsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Inflate the layout for this fragment
        int[] settings = ((GameActivity) getActivity()).getSettings();

        View toreturn = inflater.inflate(R.layout.fragment_game_settings, container, false);
        final Spinner spinner1 = (Spinner) toreturn.findViewById(R.id.spinner1);
        spinner1.setSelection(((GameActivity) getActivity()).getAPP_LANGUAGE());

        final SeekBar sb = (SeekBar) toreturn.findViewById(R.id.seekbar);
        sb.setProgress(settings[2]);

        final Switch sw = (Switch) toreturn.findViewById(R.id.mySwitch);
        if (settings[3] == 0) {
            sw.setChecked(false);
        } else {
            sw.setChecked(true);
        }

        Button b = (Button) toreturn.findViewById(R.id.submitS);
        ((Button) b).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                /*Toast.makeText(Fragment2.this.getActivity().getBaseContext(),
                        "clicked on Submit Button", Toast.LENGTH_LONG).show();*/

                int[] newValues = new int[4];

            }
        });


        return toreturn;
    }
}
