package com.example.quizgame2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Results extends AppCompatActivity {
    private Button back;
    private TextView result;
    private float grade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        back = (Button) findViewById(R.id.MainMenu);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain();
            }
        });

        TextView tv2 = (TextView) findViewById(R.id.PassingGrade);
        float numq = Settings.getNumQ();

        grade = (Question.getCorrect() / numq)*100;

        if (grade >= Settings.getGrade()) {
            tv2.setText("You Passed!");
        } else {
            tv2.setText("You failed!");
        }
        TextView tv = (TextView) findViewById(R.id.NumCorrect);
        tv.setText(String.format("%.2f", grade)+"%");

    }

    public void openMain() {
        Question.setCorrect();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
