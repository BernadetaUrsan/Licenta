package com.example.licenta.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.licenta.Enums.ClassTypeEnum;
import com.example.licenta.Models.TimetableRowModel;
import com.example.licenta.R;

import java.util.List;

public class TimetableAdapter extends RecyclerView.Adapter<TimetableAdapter.ViewHolder>{

    private Context context;
    private List<TimetableRowModel> listaZi;

    public TimetableAdapter(List<TimetableRowModel> listaZi, Context context) {
        this.listaZi = listaZi;
        this.context = context;
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
    public void onBindViewHolder(@NonNull TimetableAdapter.ViewHolder holder, int position) {

        String materie = listaZi.get(position).getmClassName();
        String sala = listaZi.get(position).getmLocationName();
        String oraStart = listaZi.get(position).getmStartTime();
        String oraStop = listaZi.get(position).getmEndTime();

        holder.materieTV.setText(materie);
        holder.salaTv.setText(sala);
        holder.oraStartTv.setText(oraStart);
        holder.oraStopTv.setText(oraStop);
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
        }
    }
}
