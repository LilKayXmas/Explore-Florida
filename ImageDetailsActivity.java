package com.example.exploreflorida;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class ImageDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_details);

        ImageView imageDetailsView = findViewById(R.id.imageDetailsView);

        // Get the image resource ID passed from the intent
        int imageResource = getIntent().getIntExtra("imageResource", R.drawable.placeholder_image);

        // Set the image resource to the ImageView
        imageDetailsView.setImageResource(imageResource);
    }
}
