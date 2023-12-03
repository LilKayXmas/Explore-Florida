package com.example.exploreflorida;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AttractionFeedbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction_feedback);

        TextView attractionNameTextView = findViewById(R.id.attractionNameTextView);
        TextView attractionDescriptionTextView = findViewById(R.id.attractionDescriptionTextView);
        EditText commentEditText = findViewById(R.id.commentEditText);
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        Button submitFeedbackButton = findViewById(R.id.submitFeedbackButton);
        Button provideAdditionalFeedbackButton = findViewById(R.id.provideAdditionalFeedbackButton); // Add this line

        // Retrieve attraction details from the intent
        String attractionName = getIntent().getStringExtra("attractionName");
        String attractionDescription = getIntent().getStringExtra("attractionDescription");

        // Set the attraction details to the respective views
        attractionNameTextView.setText(attractionName);
        attractionDescriptionTextView.setText(attractionDescription);

        submitFeedbackButton.setOnClickListener(view -> {
            // Get user input
            String userComment = commentEditText.getText().toString();
            float userRating = ratingBar.getRating();

            // Add logic to handle user feedback (e.g., send to server, store locally)
            // You can decide where to navigate next based on the feedback
            // For now, let's assume you want to go to the ImageGridActivity
            // Replace ImageGridActivity.class with the appropriate next activity
            startActivity(new Intent(AttractionFeedbackActivity.this, ImageGridActivity.class));
        });

        // Set click listener for the "Provide Additional Feedback" button
        provideAdditionalFeedbackButton.setOnClickListener(view -> {
            // Start the FeedbackActivity to collect additional feedback
            Intent intent = new Intent(AttractionFeedbackActivity.this, FeedbackActivity.class);
            startActivity(intent);
        });
    }
}
