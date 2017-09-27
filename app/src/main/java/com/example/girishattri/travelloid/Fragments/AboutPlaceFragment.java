package com.example.girishattri.travelloid.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.girishattri.travelloid.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutPlaceFragment extends Fragment {


    public AboutPlaceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about_place, container, false);
    }

}
