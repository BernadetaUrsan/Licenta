package com.example.licenta.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.licenta.Activities.OnePostActivity;
import com.example.licenta.Models.PostModel;
import com.example.licenta.Models.StudentModel;
import com.example.licenta.R;

import java.util.ArrayList;
import java.util.List;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.ViewHolder> implements Filterable {

    private List<StudentModel> studentsPosts;
    private List<StudentModel> studentsPostsFiltered;
    private Context context;

    public StudentsAdapter(List<StudentModel> studentsPosts, Context context) {
        this.studentsPosts = studentsPosts;
        this.studentsPostsFiltered = studentsPosts;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.row_students, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final String id = studentsPostsFiltered.get(position).getUserId();
        String nume_prenume = studentsPostsFiltered.get(position).getFullName();
        String email = studentsPostsFiltered.get(position).getEmail();
        String telefon = studentsPostsFiltered.get(position).getPhoneNumber().toString();

        holder.numePrenumeTV.setText(nume_prenume);
        holder.emailTv.setText(email);
        holder.telefonTv.setText(telefon);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OnePostActivity.class);
                intent.putExtra("id_key",id);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentsPostsFiltered.size();
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();

                if(constraint == null || constraint.length() == 0){
                    filterResults.count = studentsPosts.size();
                    filterResults.values = studentsPosts;
                }
                else{
                    String searchStr = constraint.toString().toLowerCase();
                    List<StudentModel> resultData = new ArrayList<>();
                    for(StudentModel studentModel:studentsPosts){
                        if(studentModel.getFullName().contains(searchStr) || studentModel.getEmail().contains(searchStr) || studentModel.getPhoneNumber().contains(searchStr)){
                            resultData.add(studentModel);
                        }
                        filterResults.count = resultData.size();
                        filterResults.values = resultData;
                    }
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                studentsPostsFiltered = (List<StudentModel>) results.values;
                notifyDataSetChanged();
            }
        };
        return filter;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView numePrenumeTV;
        private TextView emailTv;
        private TextView telefonTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            initializeViews(itemView);
        }

        private void initializeViews(View itemView)
        {
            numePrenumeTV= itemView.findViewById(R.id.tv_nume_prenume);
            emailTv= itemView.findViewById(R.id.tv_email);
            telefonTv= itemView.findViewById(R.id.tv_telefon);
        }
    }
}
