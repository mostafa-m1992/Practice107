package com.shia.practice107;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.shia.practice107.fragments3.FragmentEleven;
import com.shia.practice107.fragments3.FragmentNine;
import com.shia.practice107.fragments3.FragmentTen;

public class MainActivity3 extends AppCompatActivity {

    CoordinatorLayout coordinatorLayout;
    Toolbar toolbar3;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        coordinatorLayout = findViewById(R.id.coordinatorLayout);

        this.setTitle("Page3");

        toolbar3 = findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar3);
        toolbar3.setSubtitle("this is a practice for TabLayout & ViewPager");
        toolbar3.setLogo(R.drawable.ic_baseline_tag_faces_24);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFrg(new FragmentNine(), "Item1");
        adapter.addFrg(new FragmentTen(), "Item2");
        adapter.addFrg(new FragmentEleven(), "Item3");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_baseline_timer_24);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_baseline_tablet_mac_24);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_baseline_tty_24);
    }
}