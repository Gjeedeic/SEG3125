package com.example.quizgame2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Settings extends AppCompatActivity {
    private Button back, save;
    private static float passGrade = 50;
    private static int numQ = 1;
    private EditText grade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        TextView tv = (TextView)findViewById(R.id.currentGQ);
        tv.setText("Current passing grade: "+Float.toString(passGrade)+"%"+"\nCurrent number of questions: "+Integer.toString(numQ));

        Spinner dropdown = findViewById(R.id.numq);
        String[] items = new String[] {"","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_item, items);
        dropdown.setAdapter(adapter);

        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ItemSelected(parent, view, position, id);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        back = (Button) findViewById(R.id.Previous);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain();
            }
        });

        save = (Button) findViewById(R.id.Save);
        grade  = (EditText) findViewById(R.id.Grade);

        save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    String str = grade.getText().toString();
                    passGrade = Float.parseFloat(str);
                    if(passGrade < 0 || passGrade > 100){
                        passGrade = 50;
                    }
                } catch(NumberFormatException nfe) {
                    System.out.println("Could not parse " + nfe);
                }
                TextView tv = (TextView)findViewById(R.id.currentGQ);
                tv.setText("Current passing grade: "+Float.toString(passGrade)+"%"+"\nCurrent number of questions: "+Integer.toString(numQ));
                openMain();

            }
        });

    }

    public void ItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                break;
            case 1:
                    numQ = 1;
                break;
            case 2:
                    numQ = 2;
                break;
            case 3:
                    numQ = 3;
                break;
            case 4:
                    numQ = 4;
                break;
            case 5:
                    numQ = 5;
                break;
            case 6:
                    numQ = 6;
                break;
            case 7:
                    numQ = 7;
                break;
            case 8:
                    numQ = 8;
                break;
            case 9:
                    numQ = 9;
                break;
            case 10:
                    numQ = 10;
                break;
            case 11:
                    numQ = 11;
                break;
            case 12:
                    numQ = 12;
                break;
            case 13:
                    numQ = 13;
                break;
            case 14:
                    numQ = 14;
                break;
            case 15:
                    numQ = 15;
                break;
            case 16:
                    numQ = 16;
                break;
            case 17:
                    numQ = 17;
                break;
            case 18:
                    numQ = 18;
                break;
            case 19:
                    numQ = 19;
                break;
            case 20:
                    numQ = 20;
                break;

        }
    }

    public void openMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public static float getGrade(){
        return passGrade;
    }

    public static void setGrade(){
        passGrade = 50;
    }

    public static void setQ(){
        numQ = 1;
    }

    public static int getNumQ(){
        return numQ;
    }

}
