package com.example.exploreflorida;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SavedLocationsActivity extends AppCompatActivity {

    private List<TouristLocation> savedLocations = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_locations);

        ListView savedLocationsListView = findViewById(R.id.savedLocationsListView);

        loadSavedLocations();

        ArrayAdapter<TouristLocation> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                savedLocations
        );

        savedLocationsListView.setAdapter(adapter);
    }

    private void loadSavedLocations() {
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        String savedLocationsJson = sharedPreferences.getString("savedLocations", "");

        if (!savedLocationsJson.isEmpty()) {
            Gson gson = new Gson();
            Type type = new TypeToken<List<TouristLocation>>() {}.getType();
            savedLocations = gson.fromJson(savedLocationsJson, type);
        }
    }
}
