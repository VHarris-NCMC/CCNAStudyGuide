package com.android.ccnastudyguide;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import com.android.ccnastudyguide.R;

public class SettingsActivity extends AppCompatActivity {

    private Spinner spinnerQuestions;
    private SeekBar seekBarDifficulty;
    private Switch switchTimer;
    private SeekBar seekBarTimerDuration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Initialize views
        spinnerQuestions = findViewById(R.id.spinner_questions);
        seekBarDifficulty = findViewById(R.id.seekbar_difficulty);
        switchTimer = findViewById(R.id.switch_timer);
        seekBarTimerDuration = findViewById(R.id.seekbar_timer_duration);

        // Set number of questions dropdown options
        ArrayAdapter<CharSequence> questionsAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.number_of_questions,
                android.R.layout.simple_spinner_item
        );
        questionsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerQuestions.setAdapter(questionsAdapter);

        // Set listener for timer switch
        switchTimer.setOnCheckedChangeListener((buttonView, isChecked) -> {
            seekBarTimerDuration.setEnabled(isChecked);
            seekBarTimerDuration.setAlpha(isChecked ? 1.0f : 0.5f);
        });
    }
}
