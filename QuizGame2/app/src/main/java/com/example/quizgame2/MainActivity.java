package com.example.quizgame2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private Button settings;
    private Button picQuiz;
    private Button geoQuiz;
    private static int quizType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        settings = (Button) findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettings();
            }
        });

        picQuiz = (Button) findViewById(R.id.button1);
        picQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizType = 1;
                openQuestions();
            }
        });

        geoQuiz = (Button) findViewById(R.id.button2);
        geoQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizType = 2;
                openQuestions();
            }
        });
    }

    public void openSettings() {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    public void openQuestions() {
        Intent intent2 = new Intent(this, Question.class);
        startActivity(intent2);
    }

    public static int getType(){
        return quizType;
    }
}

