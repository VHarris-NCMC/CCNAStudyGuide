package com.android.ccnastudyguide;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MenuActivity extends AppCompatActivity {

    private Button studyButton;
    private Button quizButton;
    private Button statsButton;
    private Button settingsButton;
    private Button certifiedButton;
    private Button accountButton;
    private Button aboutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        studyButton = findViewById(R.id.studyButton);
        quizButton = findViewById(R.id.quizButton);
        statsButton = findViewById(R.id.statsButton);
        settingsButton = findViewById(R.id.settingsButton);
        certifiedButton = findViewById(R.id.certifiedButton);
        accountButton = findViewById(R.id.accountButton);
        aboutButton = findViewById(R.id.aboutButton);

        studyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStudyActivity();
            }
        });

        quizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuizActivity();
            }
        });

        statsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStatsActivity();
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettingsActivity();
            }
        });

        certifiedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCertifiedActivity();
            }
        });

        accountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAccountActivity();
            }
        });

        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAboutActivity();
            }
        });
    }

    private void openStudyActivity() {
        Intent intent = new Intent(MenuActivity.this, StudyActivity.class);
        startActivity(intent);
    }

    private void openQuizActivity() {
        Intent intent = new Intent(MenuActivity.this, QuizActivity.class);
        startActivity(intent);
    }

    private void openStatsActivity() {
        Intent intent = new Intent(MenuActivity.this, StatsActivity.class);
        startActivity(intent);
    }

    private void openSettingsActivity() {
        Intent intent = new Intent(MenuActivity.this, SettingsActivity.class);
        startActivity(intent);
    }

    private void openCertifiedActivity() {
        Intent intent = new Intent(MenuActivity.this, CertifiedActivity.class);
        startActivity(intent);
    }

    private void openAccountActivity() {
        // Handle button click to open Account activity
        Intent intent = new Intent(MenuActivity.this, AccountActivity.class);
        startActivity(intent);
    }

    private void openAboutActivity() {
        // Handle button click to open About activity
        Intent intent = new Intent(MenuActivity.this, AboutActivity.class);
        startActivity(intent);
    }
}
