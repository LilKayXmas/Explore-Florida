package com.example.exploreflorida;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button exploreButton = findViewById(R.id.exploreButton);
        Button moreFeaturesButton = findViewById(R.id.moreFeaturesButton);
        Button exploreWebButton = findViewById(R.id.exploreWebButton);

        exploreButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Categories.class);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "Error: Unable to start AttractionsListActivity", Toast.LENGTH_SHORT).show();
            }
        });

        moreFeaturesButton.setOnClickListener(view ->
                Toast.makeText(MainActivity.this, "More features coming soon!", Toast.LENGTH_SHORT).show()
        );

        exploreWebButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ExploreWebActivity.class);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "Error: Unable to start ExploreWebActivity", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
