package com.example.licenta.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.licenta.Activities.MapActivity;
import com.example.licenta.Interfaces.MapClickListener;
import com.example.licenta.Models.LocationModel;
import com.example.licenta.Models.TimetableRowModel;
import com.example.licenta.R;

import java.util.List;

import static com.example.licenta.Constants.ColorConstants.DisabledColor;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.ViewHolder> {
    private Context context;
    private List<LocationModel> locatii;
    private MapClickListener clickListener;

    public LocationAdapter(List<LocationModel> locatii, Context context, MapClickListener clickListener) {
        this.locatii = locatii;
        this.context = context;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public LocationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.row_locations, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull LocationAdapter.ViewHolder holder, final int position) {
        final LocationModel locatie = locatii.get(position);
        final String nume = locatie.getNumeLocatie();
        final Double latitudine = locatie.getLatitude();
        final Double longitudine = locatie.getLongitude();

        holder.numeTV.setText(nume);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LocationModel locationModel = new LocationModel(nume, latitudine, longitudine);
                clickListener.OnClick(locationModel);
            }
        });
    }

    @Override
    public int getItemCount() {
        return locatii.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView numeTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            initializeViews(itemView);
        }

        private void initializeViews(View itemView)
        {
            numeTV= itemView.findViewById(R.id.tv_nume_locatie);
        }
    }
}
