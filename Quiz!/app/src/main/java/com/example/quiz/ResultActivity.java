package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

import android.widget.TextView;



public class ResultActivity extends AppCompatActivity {
    private String[] answers ;
    private int answersNumber =0;
    private int correctAnswers =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        answers = getIntent().getStringArrayExtra("answers");
        correctAnswers = getIntent().getIntExtra("correctAnswers", 0);
        answersNumber = getIntent().getIntExtra("answersNumber", 0);

        TextView textViewQuestionsList = findViewById(R.id.textViewQuestionsList);
        TextView textViewRightAnswerNumber = findViewById(R.id.textViewRightAnswerNumber);

       // if (answers!=null) textViewQuestionsList.setText(String.join("", answers) );
        for (String var : answers){ textViewQuestionsList.append(var); }

       // else System.out.println("Список ответов == null");

        textViewRightAnswerNumber.setText("Правильных ответов: "+correctAnswers +" из "+  answersNumber);

    }


 /*   @Override
    public void onBackPressed() {

        Log.d("SYSTEM INFO", "Метод ResultActivity.onBackPressed()  запущен");
       //System.exit(0);
        this.finish();

    }*/
}