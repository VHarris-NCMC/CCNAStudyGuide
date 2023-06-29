package com.android.ccnastudyguide;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    private TextView flashcardTextView;
    private boolean isQuestionShowing = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        flashcardTextView = findViewById(R.id.text_flashcard);
        flashcardTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipFlashcard();
            }
        });
    }

    private void flipFlashcard() {
        if (isQuestionShowing) {
            flashcardTextView.setText("No");
            isQuestionShowing = false;
        } else {
            flashcardTextView.setText("Am I ready for the exam?");
            isQuestionShowing = true;
        }
    }
}
