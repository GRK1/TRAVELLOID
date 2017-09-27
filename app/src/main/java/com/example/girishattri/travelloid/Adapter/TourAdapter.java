package com.example.girishattri.travelloid.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.girishattri.travelloid.Common.DownloadImageAsync;
import com.example.girishattri.travelloid.Model.Tour;
import com.example.girishattri.travelloid.R;

import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Girish Attri on 12-08-2017.
 */


public class TourAdapter extends ArrayAdapter<Tour>
{
    public TourAdapter(Context context, ArrayList<Tour> tours)
    {
        super(context,0,tours);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        View view= LayoutInflater.from(getContext()).inflate(R.layout.custom_tour,parent,false);

        TextView tourname=(TextView)view.findViewById(R.id.textView);
        ImageView tourimage=(ImageView)view.findViewById(R.id.imageView);

        Tour cs = getItem(position);
        tourname.setText(cs.getName());

        try {
            DownloadImageAsync imageAsync = new DownloadImageAsync(tourimage);
            imageAsync.execute(new URL(cs.getImage()));
        }
        catch (Exception e)
        {

        }


        return view;
    }
}
