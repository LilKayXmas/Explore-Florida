package com.example.exploreflorida;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class FeedbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        // Retrieve references to UI elements
        EditText editTextFeedback = findViewById(R.id.editTextFeedback);
        Button buttonSubmitFeedback = findViewById(R.id.buttonSubmitFeedback);

        // Set click listener for the Submit Feedback button
        buttonSubmitFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get user's feedback
                String userFeedback = editTextFeedback.getText().toString();

                // TODO: Implement logic to handle the feedback (e.g., send to server, store locally)

                // Display a toast indicating successful submission
                Toast.makeText(FeedbackActivity.this, "Feedback submitted: " + userFeedback, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
