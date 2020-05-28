package com.example.licenta.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.licenta.Models.CalendarRowModel;
import com.example.licenta.Models.TimetableRowModel;
import com.example.licenta.R;

import java.util.List;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.ViewHolder> {

    private Context context;
    private List<CalendarRowModel> listaEvenimenteZi;

    public CalendarAdapter(List<CalendarRowModel> listaEvenimenteZi, Context context){
        this.listaEvenimenteZi = listaEvenimenteZi;
        this.context = context;
    }

    @NonNull
    @Override
    public CalendarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.row_calendar, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CalendarAdapter.ViewHolder holder, int position) {

        final CalendarRowModel rowModel = listaEvenimenteZi.get(position);
        String title = rowModel.getTitle();
        String location = rowModel.getLocation();
        String startHour = rowModel.getStartTime();
        holder.title.setText(title);
        holder.location.setText(location);
        holder.startTime.setText(startHour);
    }

    @Override
    public int getItemCount() {
        return listaEvenimenteZi.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView location;
        private TextView startTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            initializeViews(itemView);
        }

        private void initializeViews(View itemView)
        {
            title= itemView.findViewById(R.id.tv_title_event);
            location= itemView.findViewById(R.id.tv_location_event);
            startTime= itemView.findViewById(R.id.tv_start_hour);
        }
    }
}
