package com.example.girishattri.travelloid;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;

import com.example.girishattri.travelloid.Fragments.AboutPlaceFragment;
import com.example.girishattri.travelloid.Fragments.DescriptionFragment;
import com.example.girishattri.travelloid.Fragments.HotelsFragment;
import com.example.girishattri.travelloid.Fragments.ItineraryFragment;

public class DetailsActivity extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            //return PlaceholderFragment.newInstance(position + 1);
            Fragment fragment=null;
            switch (position)
            {
                case 0:
                    Intent intent = getIntent();
                    int packageid = intent.getIntExtra("packageid",3);
                    Bundle bundle = new Bundle();
                    Log.i("ab","packageiddetails : "+packageid);
                    bundle.putInt("packageid",packageid);
                    fragment = new DescriptionFragment();
                    fragment.setArguments(bundle);
                    break;
                case 1:
                    fragment=new ItineraryFragment();
                    break;
                case 2:
                    fragment=new AboutPlaceFragment();
                    break;
                case 3:
                    fragment=new HotelsFragment();
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Package Details";
                case 1:
                    return "Itinerary";
                case 2:
                    return "About the Place";
                case 3:
                    return "Hotels";
            }
            return null;
        }
    }
}
