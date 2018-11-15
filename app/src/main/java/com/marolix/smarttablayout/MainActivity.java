package com.marolix.smarttablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.marolix.smarttablayout.adapter.ViewPagerAdapter;
import com.marolix.smarttablayout.fragments.Accessories;
import com.marolix.smarttablayout.fragments.ExclusiveBrands;
import com.marolix.smarttablayout.fragments.HouseHold;
import com.marolix.smarttablayout.fragments.Kids;
import com.marolix.smarttablayout.fragments.Men;
import com.marolix.smarttablayout.fragments.PremiunLaundry;
import com.marolix.smarttablayout.fragments.Women;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewpager);

        tabLayout = findViewById(R.id.tabs);
        setUpViewPager();
        tabLayout.setupWithViewPager(viewPager);

    }

    private void setUpViewPager() {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new Men(), "Men");
        adapter.addFrag(new Women(), "Women");
        adapter.addFrag(new Kids(), "Kids");
        adapter.addFrag(new HouseHold(), "HouseHold");
        adapter.addFrag(new PremiunLaundry(), "PremiumLaundry");
        adapter.addFrag(new Accessories(), "Accessories");
        adapter.addFrag(new ExclusiveBrands(), "ExclusiveBrands");
        viewPager.setAdapter(adapter);

        // viewPager.setOffscreenPageLimit(-1);
        adapter.notifyDataSetChanged();
        
    }
}
