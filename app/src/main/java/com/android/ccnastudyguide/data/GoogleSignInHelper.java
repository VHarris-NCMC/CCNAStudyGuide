package com.android.ccnastudyguide.data;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import com.android.ccnastudyguide.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;

public class GoogleSignInHelper {

    private static final int RC_SIGN_IN = 1001;
    private static final String TAG = "GoogleSignInHelper";

    private static boolean isSignedIn;
    private Activity activity;
    private GoogleSignInClient googleSignInClient;
    private final OnSignInCompleteListener signInCompleteListener;

    public GoogleSignInHelper(Activity activity, OnSignInCompleteListener signInCompleteListener) {
        this.activity = activity;
        this.signInCompleteListener = signInCompleteListener;
        configureGoogleSignIn();
    }

    private void configureGoogleSignIn() {
        String clientId = String.valueOf(R.string.google_sign_in_client_id);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .requestIdToken("909949754168-3r7kjdhcger4g6nidv26v1doj30fsr3k.apps.googleusercontent.com")
                .build();
        googleSignInClient = GoogleSignIn.getClient(activity, gso);
    }

    public void signIn() {
        Intent signInIntent = googleSignInClient.getSignInIntent();
        activity.startActivityForResult(signInIntent, RC_SIGN_IN);

    }

    public void signOut() {
        googleSignInClient.signOut()
                .addOnCompleteListener(task -> signInCompleteListener.onSignOutComplete());
        isSignedIn = false;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RC_SIGN_IN) {
            try {
                // Get the signed-in account from the intent
                GoogleSignInAccount account = GoogleSignIn.getSignedInAccountFromIntent(data).getResult(ApiException.class);
                signInCompleteListener.onSignInSuccess(account);
                isSignedIn = true;
            } catch (ApiException e) {
                // Sign-in failed, handle the exception
                Log.e(TAG, "Sign-in failed. Error code: " + e.getStatusCode());
                signInCompleteListener.onSignInFailure(e);
                isSignedIn = false;
            }
        }
    }

    public boolean getIsSignedIn() {
        return isSignedIn;
    }

    public interface OnSignInCompleteListener {
        void onSignInSuccess(GoogleSignInAccount account);
        void onSignInFailure(Exception exception);
        void onSignOutComplete();
    }
}
