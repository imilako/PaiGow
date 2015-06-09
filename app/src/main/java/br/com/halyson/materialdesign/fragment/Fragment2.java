package br.com.halyson.materialdesign.fragment;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import br.com.halyson.materialdesign.R;
import br.com.halyson.materialdesign.activity.GameActivity;
import br.com.halyson.materialdesign.activity.MainActivity;

/**
 * Created by halyson on 18/12/14.
 */
public class Fragment2 extends Fragment {
    public static Fragment2 newInstance() {
        return new Fragment2();
    }
    private View mViewFragment2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViewFragment2 = inflater.inflate(R.layout.fragment_2, container, false);

        /*EditText u = (EditText) mViewFragment2.findViewById(R.id.editTextUser);
        EditText p = (EditText) mViewFragment2.findViewById(R.id.editTextPass);
        u.getBackground().setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);
        p.getBackground().setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);*/

        Button b = (Button) mViewFragment2.findViewById(R.id.buttonLogin);
        ((Button) b).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    Submit();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
                /*Toast.makeText(Fragment2.this.getActivity().getBaseContext(),
                        "clicked on Submit Button", Toast.LENGTH_LONG).show();*/

            }
        });
        return mViewFragment2;
    }

    public void Submit () throws InterruptedException, ExecutionException, TimeoutException {
        EditText u = (EditText) mViewFragment2.findViewById(R.id.editTextUser);
        EditText p = (EditText) mViewFragment2.findViewById(R.id.editTextPass);

        Button myButton = (Button) mViewFragment2.findViewById(R.id.buttonLogin);
        myButton.setEnabled(false);

        AsyncTask task = new SendToServer().execute("login", u.getText().toString(), p.getText().toString());
        String message = task.get().toString();
        Toast.makeText(Fragment2.this.getActivity().getBaseContext(),
                        message, Toast.LENGTH_LONG).show();
        myButton.setEnabled(true);
        if (message.length() > 10) {
            /*Intent intent = new Intent(HomeActivity.this, MainActivity.class);
            startActivity(intent);*/
            Intent intent = new Intent(getActivity(), GameActivity.class);
            startActivity(intent);
            getActivity().finish();
        }
    }


}
