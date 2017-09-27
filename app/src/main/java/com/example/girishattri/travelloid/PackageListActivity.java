package com.example.girishattri.travelloid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.girishattri.travelloid.Adapter.PackageAdapter;
import com.example.girishattri.travelloid.Adapter.TourAdapter;
import com.example.girishattri.travelloid.Common.DownloadJsonAsync;
import com.example.girishattri.travelloid.Common.DownloadJsonListener;
import com.example.girishattri.travelloid.Fragments.DescriptionFragment;
import com.example.girishattri.travelloid.Model.Package;
import com.example.girishattri.travelloid.Model.Tour;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;

public class PackageListActivity extends AppCompatActivity implements DownloadJsonListener {

    ListView lvPackages;
    ArrayList<Package> packages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_list);

        int tourid=getIntent().getIntExtra("tourid",0);
        lvPackages=(ListView)findViewById(R.id.listView);
        packages=new ArrayList<>();

        DownloadJsonAsync task = new DownloadJsonAsync(this);
        try
        {
            task.execute(new URL("https://travelloid.000webhostapp.com/getpackages.php?tourid="+tourid));
        }
        catch (Exception e)
        {
            Log.i("Travelloid","TourActivity : " + e.getMessage());
        }
    }

    @Override
    public void onDownloadComplete(String s)
    {
        try
        {
            JSONArray jsonArray = new JSONArray(s);
            for(int i=0;i<jsonArray.length();i++)
            {
                JSONObject jsonPackage = jsonArray.getJSONObject(i);
                Package objPackage = new Package();
                objPackage.setPackageid(jsonPackage.getInt("packageid"));
                objPackage.setTitle(jsonPackage.getString("title"));
                objPackage.setCost(jsonPackage.getDouble("cost"));
                objPackage.setDuration(jsonPackage.getString("duration"));
                objPackage.setIsactive(jsonPackage.getInt("isactive")==0?false:true);
                objPackage.setFeatured(jsonPackage.getInt("featured")==0?false:true);
                objPackage.setImage("https://travelloid.000webhostapp.com/"+jsonPackage.getString("imageurl"));
                packages.add(objPackage);

            }

            PackageAdapter adapter = new PackageAdapter(this,packages);
            lvPackages.setAdapter(adapter);
        }
        catch (Exception e)
        {
            Log.i("Travelloid","TourActivity : " + e.getMessage());
        }
    }
}
