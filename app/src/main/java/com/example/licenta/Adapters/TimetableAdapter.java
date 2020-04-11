package com.example.licenta.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.licenta.R;

import java.util.List;

public class TimetableAdapter extends RecyclerView.Adapter<TimetableAdapter.ViewHolder>{

    private Context context;
    private List<OneDayScheduleModel> listaZi;

    public TimetableAdapter(List<OneDayScheduleModel> listaZi, Context context) {
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

        String materie = listaZi.get(position).getNumeMaterie();
        String sala = listaZi.get(position).getSalaMaterie();
        String ora = listaZi.get(position).getOraMaterie();

        holder.materieTV.setText(materie);
        holder.salaTv.setText(sala);
        holder.oraTv.setText(ora);
    }

    @Override
    public int getItemCount() {
        return listaZi.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView materieTV;
        private TextView salaTv;
        private TextView oraTv;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            initializeViews(itemView);
        }

        private void initializeViews(View itemView)
        {
            materieTV= itemView.findViewById(R.id.tv_materie);
            salaTv= itemView.findViewById(R.id.tv_sala);
            oraTv= itemView.findViewById(R.id.tv_ora);
        }
    }
}
