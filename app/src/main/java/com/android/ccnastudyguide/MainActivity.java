package com.android.ccnastudyguide;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


import com.android.ccnastudyguide.data.GoogleSignInHelper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.SignInButton;

public class MainActivity extends AppCompatActivity implements GoogleSignInHelper.OnSignInCompleteListener {
    private SignInButton googleSignInButton;
    private Button skipSignInButton;
    private GoogleSignInHelper googleSignInHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        googleSignInButton = findViewById(R.id.googleSignInButton);
        skipSignInButton = findViewById(R.id.skipSignInButton);

        // Set click listener for the Skip Sign-In button
        skipSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMenuActivity();
            }
        });

        // Create an instance of GoogleSignInHelper
        googleSignInHelper = new GoogleSignInHelper(this, this);

        // Check if user is already signed in
        if (googleSignInHelper.getIsSignedIn()) {
            // User is already signed in, proceed to open menu activity
            openMenuActivity();
        } else {
            // User is not signed in, set up sign-in button click listener
            googleSignInButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    googleSignInHelper.signIn();
                }
            });
        }
    }

    private void openMenuActivity() {
        Intent intent = new Intent(MainActivity.this, MenuActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        googleSignInHelper.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onSignInSuccess(GoogleSignInAccount account) {
        // Signed in successfully, proceed to open menu activity
        openMenuActivity();
    }



    @Override
    public void onSignInFailure(Exception exception) {
        // Sign-in failed, handle error here
        Toast.makeText(this, "Sign In Error:" + exception.toString(), Toast.LENGTH_LONG).show();
        Log.e("Sign In Error: ERROR CODE: " + exception.toString()  , "signInResult:failed");

    }

    @Override
    public void onSignOutComplete() {
        // Sign-out completed, do any necessary cleanup or UI updates
    }
}
