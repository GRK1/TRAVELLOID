package com.example.girishattri.travelloid.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.girishattri.travelloid.Adapter.ItineraryAdapter;
import com.example.girishattri.travelloid.Model.Itinerary;
import com.example.girishattri.travelloid.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItineraryFragment extends Fragment {


    public ItineraryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_itinerary, container, false);
        ListView listView = view.findViewById(R.id.listView);
        ArrayList<Itinerary> ci = new ArrayList<Itinerary>();
        ci.add(new Itinerary("1","high1","high2","desc"));
        ItineraryAdapter cai = new ItineraryAdapter(getActivity(),ci);
        listView.setAdapter(cai);
        return view;
    }

}
