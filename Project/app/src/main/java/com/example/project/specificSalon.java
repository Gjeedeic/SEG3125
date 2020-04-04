package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class specificSalon extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private eAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<salonitemj> mExampleList = new ArrayList<>();
    private TextView name;
    private ImageView mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_salon);

        EditText editText = findViewById(R.id.search);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

        Bundle b = getIntent().getExtras();
        int position = b.getInt("position");

        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);

        name = (TextView) findViewById(R.id.name);
        mImage = (ImageView) findViewById(R.id.pic);

        if(position == 0 || position == 5){
            mExampleList.add(new salonitemj(R.drawable.man, "Hairdresser1", "Adara Salon and Spa 74 laurier avenue"));
            mExampleList.add(new salonitemj(R.drawable.man, "Hairdresser6", "Adara Salon and Spa 74 laurier avenue"));
            name.setText("Adara Salon and Spa");
            mImage.setImageResource(R.drawable.adara);
            mTitle.setText("Adara Salon and Spa");
        } else if(position == 1 || position == 6){
            mExampleList.add(new salonitemj(R.drawable.man, "Hairdresser2", "Paul Albert Salon 74 laurier avenue"));
            mExampleList.add(new salonitemj(R.drawable.man, "Hairdresser7", "Paul Albert Salon 74 laurier avenue"));
            name.setText("Paul Albert Salon");
            mImage.setImageResource(R.drawable.paulalbert);
            mTitle.setText("Paul Albert Salon");
        } else if(position == 2 || position == 7){
            mExampleList.add(new salonitemj(R.drawable.man, "Hairdresser3", "Salon On Stone 74 laurier avenue"));
            mExampleList.add(new salonitemj(R.drawable.man, "Hairdresser8", "Salon On Stone 74 laurier avenue"));
            name.setText("Salon On Stone");
            mImage.setImageResource(R.drawable.salononstone);
            mTitle.setText("Salon On Stone");
        } else if(position == 3 || position == 8){
            mExampleList.add(new salonitemj(R.drawable.man, "Hairdresser4", "Silkhair Studio 74 laurier avenue"));
            mExampleList.add(new salonitemj(R.drawable.man, "Hairdresser9", "Silkhair Studio 74 laurier avenue"));
            name.setText("Silkhair Studio");
            mImage.setImageResource(R.drawable.silkhair);
            mTitle.setText("Silkhair Studio");
        } else {
            mExampleList.add(new salonitemj(R.drawable.man, "Hairdresser5", "Viva Salon 74 laurier avenue"));
            mExampleList.add(new salonitemj(R.drawable.man, "Hairdresser10", "Viva Salon 74 laurier avenue"));
            name.setText("Viva Salon");
            mImage.setImageResource(R.drawable.vivasalon);
            mTitle.setText("Viva Salon");
        }

        mRecyclerView = findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new eAdapter(mExampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new eAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                if(position == 0 || position == 5){
                    openProfile(0);
                } else if(position == 1 || position == 6){
                    openProfile(1);
                } else if(position == 2 || position == 7){
                    openProfile(2);
                } else if(position == 3 || position == 8){
                    openProfile(3);
                } else {
                    openProfile(4);
                }
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
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

    private void filter(String text) {
        ArrayList<salonitemj> filteredList = new ArrayList<>();

        for (salonitemj item : mExampleList) {
            if (item.getText1().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        mAdapter.filterList(filteredList);
    }

    public void openProfile(int position) {
        Intent intent = new Intent(this, HairdresserProfile.class);
        intent.putExtra("position", position);
        startActivity(intent);
    }
}
