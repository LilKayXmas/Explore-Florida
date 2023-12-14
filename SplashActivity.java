package com.example.exploreflorida;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Start the main activity immediately
        startActivity(new Intent(this, MainActivity.class));
        finish(); // Finish the splash activity to prevent going back to it
    }
}
