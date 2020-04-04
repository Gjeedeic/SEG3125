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
import android.widget.CalendarView;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class calendar extends AppCompatActivity {
    private Button Next;
    private TextView name;
    private CalendarView calendar;
    private String date;
    private int currentposition;
    private String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        mTitle.setText("Book Appointment");

        Bundle b = getIntent().getExtras();
        int position = b.getInt("position");
        currentposition = position;

        name = (TextView) findViewById(R.id.name);
        name.setText("Hairdresser"+Integer.toString(position+1));

        calendar = (CalendarView) findViewById(R.id.calendar);

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                date = (months[month])+" "+dayOfMonth+", "+year;
            }
        });

        Next = (Button) findViewById(R.id.next);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNext(date, currentposition);
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

    public void openNext(String date, int position) {
        Intent intent = new Intent(this, pickTime.class);
        if(date == null){
            Calendar calendar = Calendar.getInstance();
            date = DateFormat.getDateInstance().format(calendar.getTime());
        }
        intent.putExtra("date", date);
        intent.putExtra("poistion", position);
        startActivity(intent);
        finish();
    }
}
