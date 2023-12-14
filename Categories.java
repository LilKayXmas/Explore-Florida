package com.example.exploreflorida;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;


import androidx.appcompat.app.AppCompatActivity;

public class Categories extends AppCompatActivity {
    Integer[] categoryImages = {R.drawable.beach, R.drawable.themepark,
            R.drawable.restaurant};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        GridView gridView = findViewById(R.id.categoryGridView);
        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener((parent, view, position, id) -> {
            // Handle item click, for example, navigate to AttractionListActivity
            Intent intent = new Intent(Categories.this, AttractionsListActivity.class);
            // Pass the selected category information if needed
            startActivity(intent);
        });
    }

    public class ImageAdapter extends BaseAdapter {
        private final Context context;

        public ImageAdapter(Context c) {
            context = c;
        }

        @Override
        public int getCount() {
            return categoryImages.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {
                // If it's not recycled, initialize some attributes
                imageView = new ImageView(context);
                imageView.setLayoutParams(new GridView.LayoutParams(330, 300));
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setPadding(16, 16, 16, 16);
            } else {
                imageView = (ImageView) convertView;
            }

            imageView.setImageResource(categoryImages[position]);
            return imageView;
        }
    }
}
