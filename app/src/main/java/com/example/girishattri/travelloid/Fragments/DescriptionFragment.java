package com.example.girishattri.travelloid.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.girishattri.travelloid.Common.DownloadJsonAsync;
import com.example.girishattri.travelloid.Common.DownloadJsonListener;
import com.example.girishattri.travelloid.Model.Description;
import com.example.girishattri.travelloid.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DescriptionFragment extends Fragment implements DownloadJsonListener{



    public DescriptionFragment() {
        // Required empty public constructor

    }


    ListView listInclusions;
    ListView listExclusions;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_description, container, false);

        Bundle bundle = getArguments();
        int packageid=bundle.getInt("packageid");
        Log.i("ab","packageiddescribe : "+packageid);

        ImageView imageView = view.findViewById(R.id.imageView);
        TextView txtOverview = view.findViewById(R.id.txtOverview);
        TextView txtpackage = view.findViewById(R.id.txtPackage);
        listInclusions = view.findViewById(R.id.listInclusions);
        listExclusions = view.findViewById(R.id.listExclusions);

        DownloadJsonAsync task = new DownloadJsonAsync(this);
        try
        {
            task.execute(new URL("https://travelloid.000webhostapp.com/getdescription.php?packageid="+packageid));
        }
        catch(Exception e)
        {
            Log.i("Travelloid","Description : " + e.getMessage());
        }

        return view;
    }

    @Override
    public void onDownloadComplete(String s){
        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONArray inclusion=jsonObject.getJSONArray("inclusions");
            JSONArray exclusion =jsonObject.getJSONArray("exclusions");

            ArrayList<String> inclusionsList = new ArrayList<String>();
            ArrayList<String> exclusionList = new ArrayList<String>();

            for(int i=0;i<inclusion.length();i++)
            {
                inclusionsList.add(inclusion.getString(i));
            }

            for(int i=0;i<exclusion.length();i++)
            {
                exclusionList.add(exclusion.getString(i));
            }

            ArrayAdapter inclusionAdapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,inclusionsList);
            ArrayAdapter exclusionAdapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1 ,inclusionsList);
            listInclusions.setAdapter(inclusionAdapter);
            listExclusions.setAdapter(exclusionAdapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
