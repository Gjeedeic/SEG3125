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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Bookappointment extends AppCompatActivity {
    private Button Next;
    private int currentposition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookappointment);

        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        mTitle.setText("Book Appointment");

        Bundle b = getIntent().getExtras();
        int position = b.getInt("position");
        currentposition = position;

        Next = (Button) findViewById(R.id.next);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNext(currentposition);
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

    public void openNext(int position) {

        EditText firstname = (EditText) findViewById(R.id.firstname);
        String f = firstname.getText().toString();

        EditText lastname = (EditText) findViewById(R.id.lastname);
        String l = lastname.getText().toString();

        EditText email = (EditText) findViewById(R.id.email);
        String e = email.getText().toString();

        EditText phone = (EditText) findViewById(R.id.phone);
        String p = phone.getText().toString();

        if (f.matches("") || l.matches("") || e.matches("") || p.matches("")) {
            Toast.makeText(this, "Please fill all the information", Toast.LENGTH_SHORT).show();
            return;
        } else  {
            Intent intent = new Intent(this, calendar.class);
            intent.putExtra("position", position);
            startActivity(intent);
            finish();
        }
    }
}
