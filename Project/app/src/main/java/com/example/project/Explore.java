package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Explore extends AppCompatActivity {
    private Button Salon;
    private Button hairdresser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

        Salon = (Button) findViewById(R.id.salon);
        Salon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSalon();
            }
        });

        hairdresser = (Button) findViewById(R.id.hairdresser);
        hairdresser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHairdresser();
            }
        });

        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        mTitle.setText("Explore");

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                openHome();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void openHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openSalon() {
        Intent intent = new Intent(this, Salon.class);
        startActivity(intent);
    }

    public void openHairdresser() {
        Intent intent = new Intent(this, Hairdresser.class);
        startActivity(intent);
    }

}
