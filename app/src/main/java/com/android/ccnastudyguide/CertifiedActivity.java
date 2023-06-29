package com.android.ccnastudyguide;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class CertifiedActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create a LinearLayout to hold the buttons vertically
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(Gravity.CENTER);

        // Create the first button
        Button button1 = new Button(this);
        button1.setText("CCNA");
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle button 1 click
                openWebsite("https://www.cisco.com/c/en/us/training-events/training-certifications/exams/registration.html");
            }
        });

        // Create the second button
        Button button2 = new Button(this);
        button2.setText("CCNA Network+");
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle button 2 click
                openWebsite("https://www.comptia.org/certifications/network");

            }
        });

        // Create the third button
        Button button3 = new Button(this);
        button3.setText("Pearson Vue");
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle button 3 click
                openWebsite("https://home.pearsonvue.com/");
            }
        });

        // Add the buttons to the LinearLayout
        linearLayout.addView(button1);
        linearLayout.addView(button2);
        linearLayout.addView(button3);

        // Set the LinearLayout as the content view of the activity
        setContentView(linearLayout);
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    private void openWebsite(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }



}
