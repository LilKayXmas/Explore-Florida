package com.example.exploreflorida;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class ImageGridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_grid);

        // Register context menu for images
        registerForContextMenu(findViewById(R.id.imageGridLayout));

        // Set click listener for images
        findViewById(R.id.image1).setOnClickListener(view -> showImageDetails(R.drawable.placeholder_image));
        findViewById(R.id.image2).setOnClickListener(view -> showImageDetails(R.drawable.placeholder_image));
        findViewById(R.id.image3).setOnClickListener(view -> showImageDetails(R.drawable.placeholder_image));
        findViewById(R.id.image4).setOnClickListener(view -> showImageDetails(R.drawable.placeholder_image));
    }

    private void showImageDetails(int imageResource) {
        Intent intent = new Intent(this, ImageDetailsActivity.class);
        intent.putExtra("imageResource", imageResource);
        startActivity(intent);
    }

    // Inflate context menu for images
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.image_context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.viewDetailsOption) {

            showImageDetails(R.drawable.placeholder_image);
            return true;
        }

        return super.onContextItemSelected(item);
    }


}
