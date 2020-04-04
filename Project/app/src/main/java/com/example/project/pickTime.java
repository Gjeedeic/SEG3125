package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class pickTime extends AppCompatActivity {
    private Button confirm;
    private TextView name;
    private TextView date;
    private Button button1, button2, button3, button4, button5;
    private int currentposition;
    String currentdate;
    String currenttime;
    boolean pressed = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_time);

        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        mTitle.setText("Book Appointment");

        Bundle b = getIntent().getExtras();
        int position = b.getInt("position");
        String daten = b.getString("date");
        currentposition = position;
        currentdate = daten;

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    button1.setBackgroundResource(R.drawable.bookedbutton);
                    button1.setText("Booked");
                    pressed = true;
                    currenttime = "1:30";

                 if(pressed) {
                    button1.setBackgroundResource(R.drawable.bookedbutton);
                    button2.setBackgroundResource(R.drawable.msgbutton);
                    button3.setBackgroundResource(R.drawable.msgbutton);
                    button4.setBackgroundResource(R.drawable.msgbutton);
                    button5.setBackgroundResource(R.drawable.msgbutton);
                    button1.setText("Booked");
                    button2.setText("Available");
                    button3.setText("Available");
                    button4.setText("Available");
                    button5.setText("Available");
                    currenttime = "1:30";
                }

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                button2.setBackgroundResource(R.drawable.bookedbutton);
                pressed = true;
                currenttime = "2:00";
                button2.setText("Booked");

                if(pressed) {
                    button1.setBackgroundResource(R.drawable.msgbutton);
                    button2.setBackgroundResource(R.drawable.bookedbutton);
                    button3.setBackgroundResource(R.drawable.msgbutton);
                    button4.setBackgroundResource(R.drawable.msgbutton);
                    button5.setBackgroundResource(R.drawable.msgbutton);
                    button1.setText("Available");
                    button2.setText("Booked");
                    button3.setText("Available");
                    button4.setText("Available");
                    button5.setText("Available");
                    currenttime = "2:00";
                }

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                button3.setBackgroundResource(R.drawable.bookedbutton);
                pressed = true;
                currenttime = "2:30";
                button3.setText("Booked");

                if(pressed) {
                    button1.setBackgroundResource(R.drawable.msgbutton);
                    button2.setBackgroundResource(R.drawable.msgbutton);
                    button3.setBackgroundResource(R.drawable.bookedbutton);
                    button4.setBackgroundResource(R.drawable.msgbutton);
                    button5.setBackgroundResource(R.drawable.msgbutton);
                    button1.setText("Available");
                    button2.setText("Available");
                    button3.setText("Booked");
                    button4.setText("Available");
                    button5.setText("Available");
                    currenttime = "2:30";
                }

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button4.setBackgroundResource(R.drawable.bookedbutton);
                pressed = true;
                currenttime = "3:00";
                button4.setText("Booked");

                if(pressed) {
                    button1.setBackgroundResource(R.drawable.msgbutton);
                    button2.setBackgroundResource(R.drawable.msgbutton);
                    button3.setBackgroundResource(R.drawable.msgbutton);
                    button4.setBackgroundResource(R.drawable.bookedbutton);
                    button5.setBackgroundResource(R.drawable.msgbutton);
                    button1.setText("Available");
                    button2.setText("Available");
                    button3.setText("Available");
                    button4.setText("Booked");
                    button5.setText("Available");
                    currenttime = "3:00";
                }

            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                button5.setBackgroundResource(R.drawable.bookedbutton);
                pressed = true;
                currenttime = "3:30";
                button5.setText("Booked");

                if(pressed) {
                    button1.setBackgroundResource(R.drawable.msgbutton);
                    button2.setBackgroundResource(R.drawable.msgbutton);
                    button3.setBackgroundResource(R.drawable.msgbutton);
                    button4.setBackgroundResource(R.drawable.msgbutton);
                    button5.setBackgroundResource(R.drawable.bookedbutton);
                    button1.setText("Available");
                    button2.setText("Available");
                    button3.setText("Available");
                    button4.setText("Available");
                    button5.setText("Booked");
                    currenttime = "3:30";
                }

            }
        });

        name = (TextView) findViewById(R.id.name);
        name.setText("Hairdresser"+Integer.toString(position+1));

        date = (TextView) findViewById(R.id.date);
        date.setText(daten);

        confirm = (Button) findViewById(R.id.confirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openConfirm(currentposition, currentdate, currenttime);
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

    public void openConfirm(int position, String date, String time) {
        if(pressed){
            Intent intent = new Intent(this, appointmentConfirm.class);
            intent.putExtra("date", date);
            intent.putExtra("poistion", position);
            intent.putExtra("time", time);
            startActivity(intent);
            finish();
        }
    }

}
