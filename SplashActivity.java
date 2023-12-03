package com.example.exploreflorida;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Start the main activity after a short delay
        startActivityWithDelay();
    }

    private void startActivityWithDelay() {
        // Delay for a short period before starting the main activity
        getWindow().getDecorView().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // Finish the splash activity to prevent going back to it
        }, getSplashDuration());
    }

    private long getSplashDuration() {
        // Define your splash screen duration here (in milliseconds)
        return 2000; // Example: 2000 milliseconds (2 seconds)
    }
}


