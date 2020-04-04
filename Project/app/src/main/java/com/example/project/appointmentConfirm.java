package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class appointmentConfirm extends AppCompatActivity {
    private Button ok;
    private TextView salonname;
    private TextView hairdressername;
    private TextView date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_confirm);

        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        mTitle.setText("Book Appointment");

        ok = (Button) findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOk();
            }
        });

        Bundle b = getIntent().getExtras();
        int position = b.getInt("position");
        String daten = b.getString("date");
        String time = b.getString("time");

        salonname = (TextView) findViewById(R.id.salonname);
        hairdressername = (TextView) findViewById(R.id.hairdressername);
        date = (TextView) findViewById(R.id.date);

        hairdressername.setText("Hairdresser"+Integer.toString(position+1));
        date.setText(daten +" at "+ time);

        if(position == 1 ||position == 6){
            salonname.setText("Adara Salon and Spa");
        } else if(position == 2 ||position == 7){
            salonname.setText("Paul Albert Salon");
        } else if(position == 3 ||position == 8){
            salonname.setText("Salon On Stone");
        } else if(position == 4 ||position == 9){
            salonname.setText("Silkhair Studio");
        } else {
            salonname.setText("Viva Salon");
        }
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

    public void openOk() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
