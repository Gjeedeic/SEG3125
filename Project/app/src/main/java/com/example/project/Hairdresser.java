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
import android.widget.TextView;

import java.util.ArrayList;

public class Hairdresser extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private eAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<salonitemj> mExampleList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salon);

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

        mExampleList.add(new salonitemj(R.drawable.man, "Hairdresser1", "Adara Salon and Spa 74 laurier avenue"));
        mExampleList.add(new salonitemj(R.drawable.man, "Hairdresser2", "Paul Albert Salon 74 laurier avenue"));
        mExampleList.add(new salonitemj(R.drawable.man, "Hairdresser3", "Salon On Stone 74 laurier avenue"));
        mExampleList.add(new salonitemj(R.drawable.man, "Hairdresser4", "Silkhair Studio 74 laurier avenue"));
        mExampleList.add(new salonitemj(R.drawable.man, "Hairdresser5", "Viva Salon 74 laurier avenue"));
        mExampleList.add(new salonitemj(R.drawable.man, "Hairdresser6", "Adara Salon and Spa 74 laurier avenue"));
        mExampleList.add(new salonitemj(R.drawable.man, "Hairdresser7", "Paul Albert Salon 74 laurier avenue"));
        mExampleList.add(new salonitemj(R.drawable.man, "Hairdresser8", "Salon On Stone 74 laurier avenue"));
        mExampleList.add(new salonitemj(R.drawable.man, "Hairdresser9", "Silkhair Studio 74 laurier avenue"));
        mExampleList.add(new salonitemj(R.drawable.man, "Hairdresser10", "Viva Salon 74 laurier avenue"));

        mRecyclerView = findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new eAdapter(mExampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        mTitle.setText("Hairdressers");

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
                    openProfile(position);
                }

            }
        });
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

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
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


    public void openProfile(int position) {
        Intent intent = new Intent(this, HairdresserProfile.class);
        intent.putExtra("position", position);
        startActivity(intent);
    }
}
