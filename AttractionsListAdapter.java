package com.example.exploreflorida;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AttractionsListAdapter extends RecyclerView.Adapter<AttractionsListAdapter.ViewHolder> {

    private final List<TouristLocation> attractionsList;

    public AttractionsListAdapter(List<TouristLocation> attractionsList) {
        this.attractionsList = attractionsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View attractionsView = inflater.inflate(R.layout.item_attraction, parent, false);
        return new ViewHolder(attractionsView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TouristLocation attraction = attractionsList.get(position);
        holder.attractionName.setText(attraction.getName());
        holder.attractionDescription.setText(attraction.getDescription());
        holder.attractionImage.setImageResource(attraction.getImageResource());
    }

    @Override
    public int getItemCount() {
        return attractionsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView attractionName;
        TextView attractionDescription;
        ImageView attractionImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            attractionName = itemView.findViewById(R.id.attractionName);
            attractionDescription = itemView.findViewById(R.id.attractionDescription);
            attractionImage = itemView.findViewById(R.id.attractionImage);
        }
    }
}
