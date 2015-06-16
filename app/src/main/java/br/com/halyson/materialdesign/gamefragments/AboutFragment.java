package br.com.halyson.materialdesign.gamefragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.halyson.materialdesign.R;
import br.com.halyson.materialdesign.activity.GameActivity;

/**
 * Created by Ivan on 12.6.2015..
 */
public class AboutFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Inflate the layout for this fragment
        View toreturn = inflater.inflate(R.layout.fragment_game_about, container, false);

        final TextView tv1 = (TextView) toreturn.findViewById(R.id.textView1);
        final TextView tv2 = (TextView) toreturn.findViewById(R.id.textView2);

        tv1.setText(((GameActivity) getActivity()).getLangString(27));
        tv2.setText(((GameActivity) getActivity()).getLangString(28));

        return toreturn;
    }
}
