package com.example.girishattri.travelloid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.girishattri.travelloid.Adapter.TourAdapter;
import com.example.girishattri.travelloid.Common.DownloadJsonAsync;
import com.example.girishattri.travelloid.Common.DownloadJsonListener;
import com.example.girishattri.travelloid.Model.Tour;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;

public class TourActivity extends AppCompatActivity implements DownloadJsonListener
{
    GridView tourGrid;
    ArrayList<Tour> tours;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour);

        DownloadJsonAsync task = new DownloadJsonAsync(this);
        try
        {
            task.execute(new URL("https://travelloid.000webhostapp.com/gettours.php"));
        }
        catch (Exception e)
        {
            Log.i("Travelloid","TourActivity : " + e.getMessage());
        }

        tours = new ArrayList<>();
        tourGrid = (GridView)findViewById(R.id.gvTours);

        tourGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(TourActivity.this,PackageListActivity.class);
                intent.putExtra("tourid",tours.get(i).getId());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDownloadComplete(String s)
    {
        try
        {
            JSONArray jsonArray = new JSONArray(s);
            for(int i=0;i<jsonArray.length();i++)
            {
                JSONObject jsonTour = jsonArray.getJSONObject(i);
                Tour tour = new Tour();
                tour.setId(jsonTour.getInt("tourid"));
                tour.setName(jsonTour.getString("tourname"));
                tour.setTitle(jsonTour.getString("tourtitle"));
                tour.setInternational(jsonTour.getInt("international")==0?false:true);
                tour.setSummary(jsonTour.getString("summary"));
                tour.setDescription(jsonTour.getString("description"));
                tour.setIsactive(jsonTour.getInt("isactive")==0?false:true);
                tour.setIsfeatured(jsonTour.getInt("featured")==0?false:true);
                tour.setImage("https://travelloid.000webhostapp.com/"+jsonTour.getString("imageurl"));
                tours.add(tour);
            }

            TourAdapter adapter = new TourAdapter(this,tours);
            tourGrid.setAdapter(adapter);
        }
        catch (Exception e)
        {
            Log.i("Travelloid","TourActivity : " + e.getMessage());
        }
    }
}
