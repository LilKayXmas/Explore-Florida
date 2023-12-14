package com.example.exploreflorida;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

public class AttractionsListActivity extends AppCompatActivity {
    public static class Attraction {
        private final String name;
        private final String description;
        private final int imageResource;
        private final String website; // Add a field for the website URL

        public Attraction(String name, String description, int imageResource, String website) {
            this.name = name;
            this.description = description;
            this.imageResource = imageResource;
            this.website = website;
        }

        // Add a getter method for the website
        public String getWebsite() {
            return website;
        }

        // Add getter methods for other fields
        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public int getImageResource() {
            return imageResource;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attractions_list);

        // Assuming you have a ListView in your layout with the id attractionsListView
        ListView attractionsListView = findViewById(R.id.attractionsListView);

        // Assuming attractionsList is a List of Attraction objects
        List<Attraction> attractionsList = getAttractions();

        // Set up an adapter to populate the ListView with attraction names
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getAttractionNames());
        attractionsListView.setAdapter(adapter);


        attractionsListView.setOnItemClickListener((parent, view, position, id) -> {
            // Get the selected attraction
            Attraction selectedAttraction = attractionsList.get(position);

            // Create an Intent to navigate to AttractionDetailsActivity
            Intent detailsIntent = new Intent(AttractionsListActivity.this, AttractionDetailsActivity.class);

            // Pass information about the selected attraction to the details screen
            detailsIntent.putExtra("attractionName", selectedAttraction.getName());
            detailsIntent.putExtra("attractionDescription", selectedAttraction.getDescription());
            detailsIntent.putExtra("attractionImageResource", selectedAttraction.getImageResource());
            detailsIntent.putExtra("attractionWebsite", selectedAttraction.getWebsite()); // Provide the website URL

            // Start AttractionDetailsActivity
            startActivity(detailsIntent);
        });

    }

    // Placeholder method to get a list of attraction names
    private List<String> getAttractionNames() {
        // Return a List<String> containing attraction names
        // Replace this with your actual data
        return Arrays.asList("Attraction 1", "Attraction 2", "Attraction 3");
    }

    // Placeholder method to get a list of attraction objects
    private List<Attraction> getAttractions() {
        // Return a List<Attraction> with your attraction data
        // Replace this with your actual data
        return Arrays.asList(
                new Attraction("Universal Studios", "Universal Studios is a popular entertainment resort located in Orlando, Florida, and also has a sister park in Hollywood, California. Universal Studios is known for its thrilling rides and attractions based on blockbuster movies. It includes themed areas like The Wizarding World of Harry Potter, Jurassic Park, and Transformers. Visitors can enjoy shows, character meet-and-greets, and immersive experiences.", R.drawable.universal,"https://www.universalorlando.com/web/en/us/theme-parks/universal-studios-florida"),
                new Attraction("Disney World", "Walt Disney World is a vast entertainment complex in Orlando, Florida, covering multiple theme parks.  It is home to several theme parks, including Magic Kingdom, Epcot, Disney's Hollywood Studios, and Disney's Animal Kingdom. Each park offers a unique experience, featuring iconic attractions, beloved characters, and magical entertainment. Disney World is known for its enchanting atmosphere and the famous Cinderella Castle.", R.drawable.disney, "https://disneyworld.disney.go.com/"),
                new Attraction("Busch Gardens", "Busch Gardens is a theme park located in Tampa, Florida, and it also has a sister park in Williamsburg, Virginia. Busch Gardens combines thrilling rides with a zoological park experience. The park features roller coasters, live shows, and animal exhibits. It is known for its diverse range of attractions, including areas inspired by different countries and cultures. Busch Gardens often integrates animal conservation and education into its attractions.", R.drawable.busch_gardens, "https://buschgardens.com/tampa/")
        );
    }
}
