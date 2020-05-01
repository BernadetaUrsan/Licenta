package com.example.licenta.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.licenta.Activities.AddClassTimetableActivity;
import com.example.licenta.Interfaces.TimetableClickListener;
import com.example.licenta.Models.TimetableRowModel;
import com.example.licenta.R;

import java.util.List;

import static com.example.licenta.Constants.ColorConstants.DisabledColor;
import static com.example.licenta.Constants.ColorConstants.GrayColor;
import static com.example.licenta.Constants.ColorConstants.MainColor;

public class TimetableAdapter extends RecyclerView.Adapter<TimetableAdapter.ViewHolder>{

    private Context context;
    private List<TimetableRowModel> listaZi;
    private TimetableClickListener clickListener;

    public TimetableAdapter(List<TimetableRowModel> listaZi, Context context, TimetableClickListener clickListener) {
        this.listaZi = listaZi;
        this.context = context;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public TimetableAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.row_timetable, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TimetableAdapter.ViewHolder holder, final int position) {
        final TimetableRowModel rowModel = listaZi.get(position);
        String materie = rowModel.getmClassName();
        String sala = rowModel.getmLocationName();
        String oraStart = rowModel.getmStartTime();
        String oraStop = rowModel.getmEndTime();
        if (materie.isEmpty() && sala.isEmpty())
        {
            holder.materieTV.setVisibility(View.GONE);
            holder.salaTv.setVisibility(View.GONE);
            holder.pauzaTv.setVisibility(View.VISIBLE);
            holder.oraStartTv.setBackgroundColor(Color.parseColor(DisabledColor));
            holder.oraStopTv.setBackgroundColor(Color.parseColor(DisabledColor));
        }
        else{
            holder.materieTV.setVisibility(View.VISIBLE);
            holder.salaTv.setVisibility(View.VISIBLE);
            holder.pauzaTv.setVisibility(View.GONE);
            holder.oraStartTv.setBackgroundColor(Color.parseColor(MainColor));
            holder.oraStopTv.setBackgroundColor(Color.parseColor(GrayColor));
    }

        holder.materieTV.setText(materie);
        holder.salaTv.setText(sala);
        holder.oraStartTv.setText(oraStart);
        holder.oraStopTv.setText(oraStop);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.OnClick(rowModel, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaZi.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView materieTV;
        private TextView salaTv;
        private TextView oraStartTv;
        private TextView oraStopTv;
        private ImageView pauzaTv;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            initializeViews(itemView);
        }

        private void initializeViews(View itemView)
        {
            materieTV= itemView.findViewById(R.id.tv_materie);
            salaTv= itemView.findViewById(R.id.tv_sala);
            oraStartTv= itemView.findViewById(R.id.tv_oraStart);
            oraStopTv= itemView.findViewById(R.id.tv_oraStop);
            pauzaTv= itemView.findViewById(R.id.iv_pauza);
        }
    }
}