package com.example.girishattri.travelloid.Common;


import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class DownloadJsonAsync extends AsyncTask<URL,Void,String>
{
    DownloadJsonListener listener;

    public DownloadJsonAsync(DownloadJsonListener listener)
    {
        this.listener=listener;
    }

    @Override
    protected void onPostExecute(String s)
    {
        try {
            listener.onDownloadComplete(s);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected String doInBackground(URL... urls)
    {
        if(urls.length==0) {
            Log.i("Travelloid","DownloadJsonAsync : Nil URL");
            return null;
        }


        String result="";
        try
        {
            URL url = urls[0];
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();

            connection.setReadTimeout(20000);
            connection.setConnectTimeout(20000);
            connection.setRequestMethod("GET");

            InputStream stream = connection.getInputStream();
            InputStreamReader reader = new InputStreamReader(stream);
            BufferedReader bufferedReader = new BufferedReader(reader);

            StringBuilder builder = new StringBuilder();
            String line="";

            line=bufferedReader.readLine();
            while(line!=null)
            {
                builder.append(line);
                line=bufferedReader.readLine();
            }
            result=builder.toString();
        }
        catch (Exception e)
        {
            Log.i("Travelloid","DownloadJsonAsync : " + e.getMessage());
        }
        return result;
    }
}
