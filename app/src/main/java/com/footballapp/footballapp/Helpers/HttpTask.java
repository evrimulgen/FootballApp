package com.footballapp.footballapp.Helpers;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

import static android.support.constraint.Constraints.TAG;

public class HttpTask extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... strings) {
        try{
            return downloadContent(strings[0]);
        }catch (Exception ex){
            return null;
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Log.d("Task executed", result);
    }

    private String downloadContent(String myurl) throws IOException {
        InputStream is = null;

        try {
            URL url = new URL(myurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.connect();
            int response = conn.getResponseCode();
            Log.d(TAG, "The response is: " + response);
            is = conn.getInputStream();

            // Convert the InputStream into a string
            String contentAsString = convertInputStreamToString(is);
            return contentAsString;
        }catch (Exception ex){
            ex.printStackTrace();
            return "";
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    public String convertInputStreamToString(InputStream stream) throws IOException, UnsupportedEncodingException {
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(stream))) {
            return buffer.lines().collect(Collectors.joining("\n"));
        }
    }
}
