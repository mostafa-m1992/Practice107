package com.shia.practice107;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.shia.practice107.fragments1.FragmentFive;
import com.shia.practice107.fragments1.FragmentFour;
import com.shia.practice107.fragments1.FragmentOne;
import com.shia.practice107.fragments1.FragmentThree;
import com.shia.practice107.fragments1.FragmentTwo;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    CoordinatorLayout coordinatorLayout;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    String[] items = {"level1", "level2", "level3", "level4", "level5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coordinatorLayout = findViewById(R.id.coordinatorLayout);
        this.setTitle("Page1");

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setSubtitle("this is a practice for NavigationView");
        toolbar.setLogo(R.drawable.ic_baseline_accessibility_new_24);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int myId = item.getItemId();

        switch (myId){
            case R.id.item1:
                FragmentOne fragmentOne = new FragmentOne();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.toolbarFrame, fragmentOne);
                fragmentTransaction.commit();
                break;
            case R.id.item2:
                FragmentTwo fragmentTwo = new FragmentTwo();
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.toolbarFrame, fragmentTwo);
                transaction.commit();
                break;
            case R.id.item3:
                FragmentThree fragmentThree = new FragmentThree();
                FragmentManager manager1 = getSupportFragmentManager();
                FragmentTransaction transaction1 = manager1.beginTransaction();
                transaction1.replace(R.id.toolbarFrame, fragmentThree);
                transaction1.commit();
                break;
            case R.id.item4:
                FragmentFour four = new FragmentFour();
                FragmentManager manager2 = getSupportFragmentManager();
                FragmentTransaction transaction2 = manager2.beginTransaction();
                transaction2.replace(R.id.toolbarFrame, four);
                transaction2.commit();
                break;
            case R.id.item5:
                FragmentFive five = new FragmentFive();
                FragmentManager manager3 = getSupportFragmentManager();
                FragmentTransaction transaction3 = manager3.beginTransaction();
                transaction3.replace(R.id.toolbarFrame, five);
                transaction3.commit();
                break;
            case R.id.item6:
                chooseItem();
                break;
            case R.id.item7:
                register();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void chooseItem() {
        new AlertDialog.Builder(this)
                .setTitle("Choose any Item you want")
                .setSingleChoiceItems(items, 2, null)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,  "your item selected", Toast.LENGTH_SHORT).show();
                    }
                })
                .create()
                .show();
    }

    private void register() {
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.custom_form, null);

        new AlertDialog.Builder(this)
                .setTitle("registration")
                .setCancelable(false)
                .setView(view)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Snackbar snackbar = Snackbar.make(coordinatorLayout, "Your Registration Done", Snackbar.LENGTH_LONG);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int optionId = item.getItemId();

        switch (optionId){
            case R.id.page2:
                startActivity(new Intent(this, MainActivity2.class));
                break;
            case R.id.page3:
                startActivity(new Intent(this, MainActivity3.class));
                break;
            case R.id.page4:
                startActivity(new Intent(this, MainActivity4.class));
                break;
            case R.id.page5:
                startActivity(new Intent(this, MainActivity5.class));
                break;
            case R.id.page6:
                startActivity(new Intent(this, MainActivity6.class));
                break;
            case R.id.page7:
                startActivity(new Intent(this, MainActivity7.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}