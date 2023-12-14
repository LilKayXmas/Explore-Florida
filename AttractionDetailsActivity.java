package com.example.exploreflorida;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class AttractionDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction_details);

        TextView attractionNameTextView = findViewById(R.id.attractionNameTextView);
        TextView attractionDescriptionTextView = findViewById(R.id.attractionDescriptionTextView);
        ImageView attractionImageView = findViewById(R.id.attractionImageView);
        Button loadWebsiteButton = findViewById(R.id.loadWebsiteButton);
        Button feedbackButton = findViewById(R.id.feedbackButton);

        String attractionName = getIntent().getStringExtra("attractionName");
        String attractionDescription = getIntent().getStringExtra("attractionDescription");
        int attractionImageResource = getIntent().getIntExtra("attractionImageResource", R.drawable.placeholder_image);

        attractionNameTextView.setText(attractionName);
        attractionDescriptionTextView.setText(attractionDescription);

        // Using Glide library to load the image
        Glide.with(this)
                .load(attractionImageResource)
                .placeholder(R.drawable.placeholder_image)
                .into(attractionImageView);

        // Add click listener to the Load Website button
        loadWebsiteButton.setOnClickListener(view -> {
            // Start ExploreWebActivity with the attraction's website URL
            String attractionWebsite = getIntent().getStringExtra("attractionWebsite");
            if (attractionWebsite != null && !attractionWebsite.isEmpty()) {
                Intent intent = new Intent(AttractionDetailsActivity.this, ExploreWebActivity.class);
                intent.putExtra("websiteUrl", attractionWebsite);
                startActivity(intent);
            }
        });

        // Add click listener to the Feedback button
        feedbackButton.setOnClickListener(view -> {
            // Start AttractionFeedbackActivity
            Intent intent = new Intent(AttractionDetailsActivity.this, AttractionFeedbackActivity.class);
            startActivity(intent);
        });
    }
}
