package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button Explore;
    private Button Bookappointment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Explore = (Button) findViewById(R.id.explore);
        Explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openExplore();
            }
        });

        Bookappointment = (Button) findViewById(R.id.Bookappointment);
        Bookappointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBookappointment();
            }
        });
    }


    public void openExplore() {
        Intent intent = new Intent(this, Explore.class);
        startActivity(intent);
    }

    public void openBookappointment() {
        Intent intent = new Intent(this, Salon.class);
        startActivity(intent);
    }
}
