package br.com.halyson.materialdesign.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.halyson.materialdesign.R;
import br.com.halyson.materialdesign.activity.HomeActivity;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by halyson on 18/12/14.
 */
public class Fragment2 extends Fragment {
    public static Fragment2 newInstance() {
        return new Fragment2();
    }
    private View mViewFragment2;
    String fromAT0 = "startingvalue";
    String fromAT = "startingvalue";
    private final String USER_AGENT = "Mozilla/5.0";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViewFragment2 = inflater.inflate(R.layout.fragment_2, container, false);
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
        /*Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
        finish();*/

        EditText u = (EditText) mViewFragment2.findViewById(R.id.editTextUser);
        EditText p = (EditText) mViewFragment2.findViewById(R.id.editTextPass);

        //u.setText("blablablabblballabl");

        AsyncTask task = new SendLogin().execute(u.getText().toString(), p.getText().toString());
        int waitCheck = 0;
        while (fromAT.equals(fromAT0)) {
            if (waitCheck > 30) {
                break;
            }
            android.os.SystemClock.sleep(500);
            waitCheck++;
        }
        if (waitCheck > 30) {
            fromAT = "Time out!";
        }
        u.setText(fromAT);
    }

    private class SendLogin extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            String returned = null;
            try {
                returned = sendPost(params[0], params[1]);
            } catch (Exception e) {
                e.printStackTrace();
            }
            fromAT = returned;
            return returned;

        }

        private String sendPost(String username, String password) throws Exception {
            String url = "http://loginserver-env.elasticbeanstalk.com/index.php";

            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost(url);

            // add header
            post.setHeader("User-Agent", USER_AGENT);

            List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
            urlParameters.add(new BasicNameValuePair("username", username));
            urlParameters.add(new BasicNameValuePair("password", password));

            post.setEntity(new UrlEncodedFormEntity(urlParameters));

            //execute send
            HttpResponse response = client.execute(post);

            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }

            return result.toString();
        }

        @Override
        protected void onPostExecute(String result) {
        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onProgressUpdate(Void... values) {
        }
    }
}
