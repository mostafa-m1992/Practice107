package com.shia.practice107;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.shia.practice107.fragments4.FragmentFourteen;
import com.shia.practice107.fragments4.FragmentThirteen;
import com.shia.practice107.fragments4.FragmentTwelve;

public class MainActivity4 extends AppCompatActivity {

    CoordinatorLayout coordinatorLayout;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        coordinatorLayout = findViewById(R.id.coordinatorLayout);

        this.setTitle("Page4");

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(MenuItem item) {

                int myItemId = item.getItemId();

                switch (myItemId) {
                    case R.id.item12:
                        FragmentTwelve twelve = new FragmentTwelve();
                        FragmentManager manager = getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        transaction.replace(R.id.frameLayout2, twelve);
                        transaction.commit();
                        break;
                    case R.id.item13:
                        FragmentThirteen thirteen = new FragmentThirteen();
                        FragmentManager manager1 = getSupportFragmentManager();
                        FragmentTransaction transaction1 = manager1.beginTransaction();
                        transaction1.replace(R.id.frameLayout2, thirteen);
                        transaction1.commit();
                        break;
                    case R.id.item14:
                        FragmentFourteen fourteen = new FragmentFourteen();
                        FragmentManager manager2 = getSupportFragmentManager();
                        FragmentTransaction transaction2 = manager2.beginTransaction();
                        transaction2.replace(R.id.frameLayout2, fourteen);
                        transaction2.commit();
                        break;
                }
            }
        });
    }
}