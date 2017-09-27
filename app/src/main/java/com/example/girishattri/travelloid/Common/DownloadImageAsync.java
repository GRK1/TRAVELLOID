package com.example.girishattri.travelloid.Common;

/**
 * Created by Girish Attri on 12-08-2017.
 */

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class DownloadImageAsync extends AsyncTask<URL,Void,Bitmap>
{
    ImageView imageView;

    public DownloadImageAsync(ImageView imageView)
    {
        this.imageView=imageView;
    }


    @Override
    protected void onPostExecute(Bitmap bitmap)
    {
        imageView.setImageBitmap(bitmap);
    }

    @Override
    protected Bitmap doInBackground(URL... urls)
    {
        if(urls.length==0) {
            Log.i("Travelloid","DownloadJsonAsync : Nil URL");
            return null;
        }

        Bitmap bitmap=null;
        try
        {
            URL url = urls[0];
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();

            connection.setReadTimeout(20000);
            connection.setConnectTimeout(20000);
            connection.setRequestMethod("GET");

            InputStream stream = connection.getInputStream();
            bitmap= BitmapFactory.decodeStream(stream);
        }
        catch (Exception e)
        {
            Log.i("Travelloid","DownloadJsonAsync : " + e.getMessage());
        }
        return bitmap;
    }
}
