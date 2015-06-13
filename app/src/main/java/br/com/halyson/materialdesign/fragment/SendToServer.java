package br.com.halyson.materialdesign.fragment;

import android.os.AsyncTask;

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

import br.com.halyson.materialdesign.interfaces.Konstante;

/**
 * Created by Ivan on 23.5.2015..
 */
public class SendToServer extends AsyncTask<String, Void, String> implements Konstante{

    String url = SERVER_LOCATION;
    String type = null;
    String username = null;
    String password = null;
    String repeat = null;
    String cookie = null;

    @Override
    protected String doInBackground(String... params) {
        String returned = null;
        type = params[0];
        switch (type) {
            case "login":
                url += LOGIN_URL;
                username = params[1];
                password = params[2];
                break;
            case "signup":
                url += SIGNUP_URL;
                username = params[1];
                password = params[2];
                repeat = params[3];
                break;
            case "logout":
                username = params[1];
                cookie = params[2];
                url += LOGOUT_URL;
                break;
            case "getdata":
                username = params[1];
                cookie = params[2];
                url += GET_DATA_URL;
                break;
        }
        try {
            returned = sendPost();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returned;

    }

    public String sendPost() throws Exception {
        //String url = "http://loginserver-env.elasticbeanstalk.com/index.php";

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        // add header
        post.setHeader("User-Agent", USER_AGENT);

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        switch (type) {
            case "login":
                urlParameters.add(new BasicNameValuePair("username", username));
                urlParameters.add(new BasicNameValuePair("password", password));
                break;
            case "signup":
                urlParameters.add(new BasicNameValuePair("username", username));
                urlParameters.add(new BasicNameValuePair("password", password));
                urlParameters.add(new BasicNameValuePair("repeat", repeat));
                break;
            case "logout":
                urlParameters.add(new BasicNameValuePair("username", username));
                urlParameters.add(new BasicNameValuePair("cookie", cookie));
                break;
            case "getdata":
                urlParameters.add(new BasicNameValuePair("username", username));
                urlParameters.add(new BasicNameValuePair("cookie", cookie));
                break;

        }

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