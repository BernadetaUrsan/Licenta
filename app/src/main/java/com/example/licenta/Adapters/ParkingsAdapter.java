package com.example.licenta.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.licenta.Models.ParkingsPosts;
import com.example.licenta.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ParkingsAdapter extends RecyclerView.Adapter<ParkingsAdapter.ViewHolder> {

    private List<ParkingsPosts> parkingsPosts;
    private Context context;

    public ParkingsAdapter(List<ParkingsPosts> parkingsPosts, Context context) {
        this.parkingsPosts = parkingsPosts;
        this.context = context;
    }

    @NonNull
    @Override
    public ParkingsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.row_yeargroup_posts, parent, false);
       ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ParkingsAdapter.ViewHolder holder, int position) {

        String title = parkingsPosts.get(position).getTitle();
        String message = parkingsPosts.get(position).getMessage();
        String date = parkingsPosts.get(position).getDate();
        String hour = parkingsPosts.get(position).getHour();

        holder.titleTv.setText(title);
        holder.messageTv.setText(message);
        holder.dateTv.setText(date);
        holder.hourTv.setText(hour);
    }

    @Override
    public int getItemCount() {
        return parkingsPosts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView titleTv;
        private TextView messageTv;
        private TextView dateTv;
        private TextView hourTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            initializeViews(itemView);
        }

        private void initializeViews(View itemView)
        {
            titleTv= itemView.findViewById(R.id.tv_title_subject);
            messageTv= itemView.findViewById(R.id.tv_text_subject);
            dateTv= itemView.findViewById(R.id.tv_date);
            hourTv= itemView.findViewById(R.id.tv_hour);
        }
    }
}
