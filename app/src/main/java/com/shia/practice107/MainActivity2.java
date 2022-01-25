package com.shia.practice107;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigationrail.NavigationRailMenuView;
import com.google.android.material.navigationrail.NavigationRailView;
import com.google.android.material.snackbar.Snackbar;
import com.shia.practice107.fragments2.FragmentEight;
import com.shia.practice107.fragments2.FragmentSeven;
import com.shia.practice107.fragments2.FragmentSix;

public class MainActivity2 extends AppCompatActivity {

    CoordinatorLayout coordinatorLayout;
    NavigationRailView navigationRailView;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        coordinatorLayout = findViewById(R.id.coordinatorLayout);

        this.setTitle("Page2");

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity2.this, "fab clicked", Toast.LENGTH_SHORT).show();
            }
        });

        navigationRailView = findViewById(R.id.navigationRailView);
        navigationRailView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                int myItemId = item.getItemId();

                switch (myItemId) {
                    case R.id.item8:
                        FragmentSix six = new FragmentSix();
                        FragmentManager manager = getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        transaction.replace(R.id.frameLayout, six);
                        transaction.commit();
                        break;
                    case R.id.item9:
                        FragmentSeven seven = new FragmentSeven();
                        FragmentManager manager1 = getSupportFragmentManager();
                        FragmentTransaction transaction1 = manager1.beginTransaction();
                        transaction1.replace(R.id.frameLayout, seven);
                        transaction1.commit();
                        break;
                    case R.id.item10:
                        FragmentEight eight = new FragmentEight();
                        FragmentManager manager2 = getSupportFragmentManager();
                        FragmentTransaction transaction2 = manager2.beginTransaction();
                        transaction2.replace(R.id.frameLayout, eight);
                        transaction2.commit();
                        break;
                    case R.id.item11:
                        runAlert();
                        break;
                }
                return true;
            }
        });
    }

    private void runAlert() {
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.custom_dialog, null);

        new AlertDialog.Builder(this)
                .setTitle("Insert Your Information")
                .setView(view)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Snackbar snackbar = Snackbar.make(coordinatorLayout, "your Information registered", Snackbar.LENGTH_LONG);
                        snackbar.setDuration(3000);
                        snackbar.setAction("Ok", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                snackbar.dismiss();
                            }
                        });
                        snackbar.show();
                    }
                })
                .create()
                .show();
    }

}