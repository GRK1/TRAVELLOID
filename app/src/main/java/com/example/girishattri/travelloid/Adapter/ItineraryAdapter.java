package com.example.girishattri.travelloid.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.girishattri.travelloid.Model.Itinerary;
import com.example.girishattri.travelloid.R;

import java.util.ArrayList;

/**
 * Created by Abhishek on 9/14/2017.
 */

public class ItineraryAdapter extends ArrayAdapter<Itinerary> {
    public ItineraryAdapter(@NonNull Context context, ArrayList<Itinerary> resource) {
        super(context,0, resource);
    }
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.custom_itinerary,parent,false);

        TextView day = view.findViewById(R.id.txtDays);
        TextView highlight1 = view.findViewById(R.id.txtHighlight1);
        TextView highlight2 = view.findViewById(R.id.txtHighlight2);
        TextView description = view.findViewById(R.id.txtDescription);

        Itinerary itinerary = getItem(position);
        day.setText(itinerary.getDay());
        highlight1.setText(itinerary.getHighlight1());
        highlight2.setText(itinerary.getHighlight2());
        description.setText(itinerary.getDescription());
        return view;
    }
}
