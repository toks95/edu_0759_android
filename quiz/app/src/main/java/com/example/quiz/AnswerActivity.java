package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {
    private TextView answerTextView;
    private boolean isAnswerTrue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        answerTextView = findViewById(R.id.answerTextView);
        isAnswerTrue = getIntent().getBooleanExtra("answer", true);
        // Тернарный оператор
        answerTextView.setText(isAnswerTrue?"Да":"Нет");


        /*if (isAnswerTrue){
            answerTextView.setText("Да");
        } else {
            answerTextView.setText("Нет");
        }*/
    }
}