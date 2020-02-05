package com.example.quizgame2;
import android.content.Intent;
import android.os.Bundle;



import androidx.appcompat.app.AppCompatActivity;


import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Question extends AppCompatActivity {
    private String[] Questions = {"What is 2+2?", "What is 3+3"};
    private String[] Questions2 = {"What is the sum of the angles in a triangle?", "What is the sum of the angles in a square?"};
    private String[] Answers = {"4", "3", "22", "6", "6", "33", "9", "7"};
    private String[] Answers2 = {"180", "90", "45", "360", "360", "90", "180", "540"};
    private int currentSetOfQ = 0;
    private Button next;
    private static int correct;
    private RadioButton QuestionA1, a;
    private RadioGroup answers;
    private int ans = 1;
    private int numq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        if(MainActivity.getType() == 1){
            TextView tv = (TextView)findViewById(R.id.title);
            tv.setText("Math Quiz");
        } else {
            TextView tv = (TextView)findViewById(R.id.title);
            tv.setText("Geometry Quiz");
        }
        numq = Settings.getNumQ();
        display();

        next = (Button) findViewById(R.id.Next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNext();
            }
        });

    }

    public void display(){
        if(currentSetOfQ == 0 &&  MainActivity.getType() == 1) {
            TextView tv = (TextView) findViewById(R.id.Question);
            tv.setText("Q"+Integer.toString(ans)+": "+Questions[0]);

            RadioButton rd = (RadioButton) findViewById(R.id.QuestionA1);
            rd.setText(Answers[0]);

            RadioButton rd1 = (RadioButton) findViewById(R.id.QuestionA2);
            rd1.setText(Answers[1]);

            RadioButton rd2 = (RadioButton) findViewById(R.id.QuestionA3);
            rd2.setText(Answers[2]);

            RadioButton rd3 = (RadioButton) findViewById(R.id.QuestionA4);
            rd3.setText(Answers[3]);
            currentSetOfQ = 1;
        } else if(currentSetOfQ == 1 &&  MainActivity.getType() == 1){
            TextView tv = (TextView) findViewById(R.id.Question);
            tv.setText("Q"+Integer.toString(ans)+": "+Questions[1]);

            RadioButton rd = (RadioButton) findViewById(R.id.QuestionA1);
            rd.setText(Answers[4]);

            RadioButton rd1 = (RadioButton) findViewById(R.id.QuestionA2);
            rd1.setText(Answers[5]);

            RadioButton rd2 = (RadioButton) findViewById(R.id.QuestionA3);
            rd2.setText(Answers[6]);

            RadioButton rd3 = (RadioButton) findViewById(R.id.QuestionA4);
            rd3.setText(Answers[7]);
            currentSetOfQ = 0;
        }else if(currentSetOfQ == 0 &&  MainActivity.getType() == 2) {
            TextView tv = (TextView) findViewById(R.id.Question);
            tv.setText("Q"+Integer.toString(ans)+": "+Questions2[0]);

            RadioButton rd = (RadioButton) findViewById(R.id.QuestionA1);
            rd.setText(Answers2[0]);

            RadioButton rd1 = (RadioButton) findViewById(R.id.QuestionA2);
            rd1.setText(Answers2[1]);

            RadioButton rd2 = (RadioButton) findViewById(R.id.QuestionA3);
            rd2.setText(Answers2[2]);

            RadioButton rd3 = (RadioButton) findViewById(R.id.QuestionA4);
            rd3.setText(Answers2[3]);
            currentSetOfQ = 1;
        }else if(currentSetOfQ == 1 &&  MainActivity.getType() == 2) {
            TextView tv = (TextView) findViewById(R.id.Question);
            tv.setText("Q"+Integer.toString(ans)+": "+Questions2[1]);

            RadioButton rd = (RadioButton) findViewById(R.id.QuestionA1);
            rd.setText(Answers2[4]);

            RadioButton rd1 = (RadioButton) findViewById(R.id.QuestionA2);
            rd1.setText(Answers2[5]);

            RadioButton rd2 = (RadioButton) findViewById(R.id.QuestionA3);
            rd2.setText(Answers2[6]);

            RadioButton rd3 = (RadioButton) findViewById(R.id.QuestionA4);
            rd3.setText(Answers2[7]);
            currentSetOfQ = 0;
        }
    }

    public void openNext() {
        answers = findViewById(R.id.answers);
        int selectedId = answers.getCheckedRadioButtonId();
        a = (RadioButton) findViewById(selectedId);
        QuestionA1 = findViewById(R.id.QuestionA1);

        if(a == QuestionA1){
            correct++;
        }

        if(answers != null){
            answers.clearCheck();
        }

        if(ans < numq){
            ans++;
            display();
        } else {
            ans = 1;
            openResults();
        }
    }

    public void openResults() {
        Intent intent = new Intent(this, Results.class);
        startActivity(intent);
    }

    public static int getCorrect(){
        return correct;
    }
    public static void setCorrect(){
      correct = 0;
    }

}