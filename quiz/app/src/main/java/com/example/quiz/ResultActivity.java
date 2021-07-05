package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    private TextView userQuestionsAnswersView;
    private TextView score;
    private ArrayList<String> userQuestionsAnswers = new ArrayList<>();
    private String tempQA = "";
    private int quantityCorrectAnswers;
    private int quantityQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        userQuestionsAnswersView = findViewById(R.id.userQuestionsAnswers);
        score = findViewById(R.id.score);
        userQuestionsAnswers = getIntent().getStringArrayListExtra("userQuestionsAnswers");
        quantityCorrectAnswers = getIntent().getIntExtra("quantityCorrectAnswers", 0);
        quantityQuestions = getIntent().getIntExtra("quantityQuestions", 0);

        for (String uQA: userQuestionsAnswers) {
            tempQA = tempQA + uQA+"\n";
        }
        userQuestionsAnswersView.setText(tempQA);

        Double scoreValue = (Double.valueOf(quantityCorrectAnswers) / Double.valueOf(quantityQuestions)) * 100;

        score.setText(scoreValue.intValue() + " баллов из 100");



    }
}