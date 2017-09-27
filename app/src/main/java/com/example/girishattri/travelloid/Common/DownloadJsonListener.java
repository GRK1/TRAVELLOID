package com.example.girishattri.travelloid.Common;

import org.json.JSONException;

/**
 * Created by Girish Attri on 06-08-2017.
 */

public interface DownloadJsonListener
{
    void onDownloadComplete(String s) throws JSONException;
}
