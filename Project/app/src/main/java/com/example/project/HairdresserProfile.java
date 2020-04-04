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

public class HairdresserProfile extends AppCompatActivity {
    private Button contact;
    private Button book;
    private TextView name;
    private TextView salon;
    private TextView phone;
    private int currentposition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hairdresser_profile);

        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);

        name = (TextView) findViewById(R.id.name);
        salon = (TextView) findViewById(R.id.salon);
        phone = (TextView) findViewById(R.id.phone);

        Bundle b = getIntent().getExtras();
        int position = b.getInt("position");
        currentposition = position;

        name.setText("Hairdresser"+Integer.toString(position+1));
        phone.setText("+1234567890");
        mTitle.setText("Hairdresser"+Integer.toString(position+1));

        if(position == 1 ||position == 6){
            salon.setText("Adara Salon and Spa");
        } else if(position == 2 ||position == 7){
            salon.setText("Paul Albert Salon");
        } else if(position == 3 ||position == 8){
            salon.setText("Salon On Stone");
        } else if(position == 4 ||position == 9){
            salon.setText("Silkhair Studio");
        } else {
            salon.setText("Viva Salon");
        }

        contact = (Button) findViewById(R.id.msg);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openContact(currentposition);
            }
        });

        book = (Button) findViewById(R.id.book);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBook(currentposition);
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

    public void openBook(int position) {
        Intent intent = new Intent(this, Bookappointment.class);
        intent.putExtra("position", position);
        startActivity(intent);
        finish();
    }

    public void openContact(int position) {
        Intent intent = new Intent(this, Message.class);
        intent.putExtra("position", position);
        startActivity(intent);
        finish();
    }
}
