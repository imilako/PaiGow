package br.com.halyson.materialdesign.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import br.com.halyson.materialdesign.R;

/**
 * Created by halyson on 18/12/14.
 */
public class Fragment3 extends Fragment {
    public static Fragment3 newInstance() {
        return new Fragment3();
    }
    private View mViewFragment3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViewFragment3 = inflater.inflate(R.layout.fragment_3, container, false);
        Button b = (Button) mViewFragment3.findViewById(R.id.buttonLogin);

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

        return mViewFragment3;
    }

    public void Submit () throws InterruptedException, ExecutionException, TimeoutException {
        /*Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
        finish();*/

        EditText u = (EditText) mViewFragment3.findViewById(R.id.editTextUser);
        EditText p = (EditText) mViewFragment3.findViewById(R.id.editTextPass);
        EditText r = (EditText) mViewFragment3.findViewById(R.id.editTextPass1);

        AsyncTask task = new SendToServer().execute("signup", u.getText().toString(), p.getText().toString(), r.getText().toString());
        String message = task.get().toString();

        if (!message.equals("not set")) {
            int poruka = Integer.parseInt(message);
            poruka = poruka % 10;
            if (poruka == 1) {
                Toast.makeText(Fragment3.this.getActivity().getBaseContext(), "Passwords do not match!", Toast.LENGTH_SHORT).show();
            } else if (poruka == 2) {
                Toast.makeText(Fragment3.this.getActivity().getBaseContext(), "Username must contain at least 6 characters!", Toast.LENGTH_SHORT).show();
            } else if (poruka == 3) {
                Toast.makeText(Fragment3.this.getActivity().getBaseContext(), "Password must contain at least 6 characters!", Toast.LENGTH_SHORT).show();
            } else if (poruka == 4) {
                Toast.makeText(Fragment3.this.getActivity().getBaseContext(), "Username must contain only numbers and letters!", Toast.LENGTH_SHORT).show();
            } else if (poruka == 5) {
                Toast.makeText(Fragment3.this.getActivity().getBaseContext(), "Password must contain only numbers and letters!", Toast.LENGTH_SHORT).show();
            } else if (poruka == 6) {
                Toast.makeText(Fragment3.this.getActivity().getBaseContext(), "Username is already in use!", Toast.LENGTH_SHORT).show();
            } else if (poruka == 0) {
                Toast.makeText(Fragment3.this.getActivity().getBaseContext(), "Registration successful!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(Fragment3.this.getActivity().getBaseContext(), "All fields are required!", Toast.LENGTH_SHORT).show();
        }

    }

}
