package com.shia.practice107;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.shia.practice107.fragments5.FragmentFifteen;

public class MainActivity7 extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentFifteen fifteen = new FragmentFifteen();
                fifteen.show(getSupportFragmentManager(), fifteen.getTag());
            }
        });
    }
}