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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Salon extends AppCompatActivity {
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

        mExampleList.add(new salonitemj(R.drawable.adara, "Adara Salon and Spa", "Description 74 laurier avenue"));
        mExampleList.add(new salonitemj(R.drawable.paulalbert, "Paul Albert Salon", "Description 74 laurier avenue"));
        mExampleList.add(new salonitemj(R.drawable.salononstone, "Salon On Stone", "Description 74 laurier avenue"));
        mExampleList.add(new salonitemj(R.drawable.silkhair, "Silkhair Studio", "Description 74 laurier avenue"));
        mExampleList.add(new salonitemj(R.drawable.vivasalon, "Viva Salon", "Description 74 laurier avenue"));
        mExampleList.add(new salonitemj(R.drawable.adara, "Adara Salon and Spa", "Description 74 laurier avenue"));
        mExampleList.add(new salonitemj(R.drawable.paulalbert, "Paul Albert Salon", "Description 74 laurier avenue"));
        mExampleList.add(new salonitemj(R.drawable.salononstone, "Salon On Stone", "Description 74 laurier avenue"));
        mExampleList.add(new salonitemj(R.drawable.silkhair, "Silkhair Studio", "Description 74 laurier avenue"));
        mExampleList.add(new salonitemj(R.drawable.vivasalon, "Viva Salon", "Description 74 laurier avenue"));

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
        mTitle.setText("Salons");

        mAdapter.setOnItemClickListener(new eAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                openSpecific(position);
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


    public void openSpecific(int position) {
        Intent intent = new Intent(this, specificSalon.class);
        intent.putExtra("position", position);
        startActivity(intent);
    }
}
