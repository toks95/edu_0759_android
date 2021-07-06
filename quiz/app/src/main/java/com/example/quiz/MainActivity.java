package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {
        private Button yesBtn;
        private Button noBtn;
        private TextView questionTextView;
        private Button showAnswer;

        private final Question[] questions = {
                new Question(R.string.question, true),
                new Question(R.string.question1, true),
                new Question(R.string.question2, false),
                new Question(R.string.question3, false),
                new Question(R.string.question4, true),
                new Question(R.string.question5, false),
                new Question(R.string.question6, true),
                new Question(R.string.question7, false),
                new Question(R.string.question8, true),
                new Question(R.string.question9, false),
        };

        private final ArrayList <String> questionAnswers = new ArrayList<>();
        private int correctAnswer = 0;
        private int questionIndex = 0;

        private  void checkIndex (String userAnswer){
                questionAnswers.add(String.format("%s - вы ответили: %s", (String) questionTextView.getText(), userAnswer));
                if (questionIndex == questions.length - 1){
                        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                        intent.putExtra("userQuestionsAnswers", questionAnswers);
                        intent.putExtra("quantityCorrectAnswers", correctAnswer);
                        intent.putExtra("quantityQuestions", questions.length);
                        startActivity(intent);
                } else {
                        questionIndex++;
                        questionTextView.setText(questions[questionIndex].getQuestion());
                }
        }

        private void checkAnswer (Boolean condition){
                if(condition){
                        Toast.makeText(MainActivity.this, R.string.correct, Toast.LENGTH_SHORT).show();
                        correctAnswer++;
                } else{
                        Toast.makeText(MainActivity.this, R.string.incorrect, Toast.LENGTH_SHORT).show();
                }
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                Log.d("SYSTEM INFO", "Метода onCreate() запущен");

                if (savedInstanceState != null) {
                        questionIndex = savedInstanceState.getInt("questionIndex", 0);
                }

                setContentView(R.layout.activity_main);

                questionTextView = findViewById(R.id.questionTextView);
                questionTextView.setText(questions[questionIndex].getQuestion());

                yesBtn = findViewById(R.id.yesBtn);
                yesBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                checkAnswer(questions[questionIndex].isAnswer());
                                checkIndex("Да");
                        }
                });

                noBtn = findViewById(R.id.noBtn);
                noBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                checkAnswer(!questions[questionIndex].isAnswer());
                                checkIndex("Нет");
                        }

                });

                showAnswer = findViewById(R.id.showAnswer);
                showAnswer.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                Intent intent = new Intent(MainActivity.this, AnswerActivity.class );
                                intent.putExtra("answer", questions[questionIndex].isAnswer());
                                startActivity(intent);
                        }
                });
        }

        @Override
        protected void onStart() {
                super.onStart();
                Log.d("SYSTEM INFO", "Метода onStart() запущен");
        }

        @Override
        protected void onResume() {
                super.onResume();
                Log.d("SYSTEM INFO", "Метода onResume() запущен");
        }

        @Override
        protected void onPause() {
                super.onPause();
                Log.d("SYSTEM INFO", "Метода onPause() запущен");
        }

        @Override
        protected void onStop() {
                super.onStop();
                Log.d("SYSTEM INFO", "Метода onStop() запущен");
        }

        @Override
        public void onSaveInstanceState(Bundle savedInstanceState) {
                super.onSaveInstanceState (savedInstanceState);
                Log.d("SYSTEM INFO", "Метода onSaveInstanceState() запущен");
                savedInstanceState.putInt("questionIndex", questionIndex);
        }

        @Override
        protected void onDestroy() {
                super.onDestroy();
                Log.d("SYSTEM INFO", "Метода onDestroy() запущен");
        }
}