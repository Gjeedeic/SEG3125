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

public class Message extends AppCompatActivity {
    private Button send;
    private TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        send = (Button) findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSend();
            }
        });

        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        mTitle.setText("Message");

        title = (TextView) findViewById(R.id.title);

        Bundle b = getIntent().getExtras();
        int position = b.getInt("position");

        title.setText("Message to Hairdresser"+Integer.toString(position+1));
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

    public void openSend() {

        EditText name = (EditText) findViewById(R.id.fullnamedit);
        String n = name.getText().toString();
        EditText msge = (EditText) findViewById(R.id.nameedit);
        String msg = msge.getText().toString();
        if (n.matches("") && msg.matches("") ) {
            Toast.makeText(this, "You did not enter a name and message", Toast.LENGTH_SHORT).show();
            return;
        } else if(msg.matches("")){
            Toast.makeText(this, "You did not enter a message", Toast.LENGTH_SHORT).show();
            return;
        } else if(n.matches("")){
            Toast.makeText(this, "You did not enter a name", Toast.LENGTH_SHORT).show();
            return;
        } else {
            Intent intent = new Intent(this, messageConfirm.class);
            startActivity(intent);
            finish();
        }
    }
}
