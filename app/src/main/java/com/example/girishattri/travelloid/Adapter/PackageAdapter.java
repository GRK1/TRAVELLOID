package com.example.girishattri.travelloid.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.girishattri.travelloid.Common.DownloadImageAsync;
import com.example.girishattri.travelloid.DetailsActivity;
import com.example.girishattri.travelloid.Fragments.DescriptionFragment;
import com.example.girishattri.travelloid.Model.Package;
import com.example.girishattri.travelloid.Model.Tour;
import com.example.girishattri.travelloid.R;

import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Girish Attri on 13-08-2017.
 */

public class PackageAdapter extends ArrayAdapter<Package>
{
    public PackageAdapter(Context context, ArrayList<Package> packages)
    {
        super(context,0,packages);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        View view= LayoutInflater.from(getContext()).inflate(R.layout.custom_package,parent,false);

        TextView packageTitle=(TextView)view.findViewById(R.id.txtTitle);
        TextView packageDuration=(TextView)view.findViewById(R.id.txtNights);
        TextView packageCost=(TextView)view.findViewById(R.id.txtPrice);
        ImageView packageimage=(ImageView)view.findViewById(R.id.imageView);
        Button viewDetails = view.findViewById(R.id.button2);
        Button book = view.findViewById(R.id.button);

        final Package objPackage = getItem(position);
        packageTitle.setText(objPackage.getTitle());
        packageDuration.setText(objPackage.getDuration());
        packageCost.setText(objPackage.getCost()+"");

        viewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), DetailsActivity.class);
                intent.putExtra("packageid",objPackage.getPackageid());
                Log.i("ab","packageidadapter : "+objPackage.getPackageid());
                getContext().startActivity(intent);
            }
        });

        try {
            DownloadImageAsync imageAsync = new DownloadImageAsync(packageimage);
            imageAsync.execute(new URL(objPackage.getImage()));
        }
        catch (Exception e)
        {

        }

        return view;
    }
}
