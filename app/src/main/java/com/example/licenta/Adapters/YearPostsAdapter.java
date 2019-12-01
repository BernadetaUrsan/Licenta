package com.example.licenta.Adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.licenta.Models.PostModel;
import com.example.licenta.R;

import java.util.Calendar;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class YearPostsAdapter extends RecyclerView.Adapter<YearPostsAdapter.ViewHolder> {

    private List<PostModel> yearGroupPosts;
    private Context context;

    public YearPostsAdapter(List<PostModel> yearGroupPosts, Context context) {
        this.yearGroupPosts = yearGroupPosts;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.row_yeargroup_posts, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String title = yearGroupPosts.get(position).getTitle();
        String message = yearGroupPosts.get(position).getMessage();
        String date = yearGroupPosts.get(position).getDate().toString();
        String author = yearGroupPosts.get(position).getAuthorName().toString();

        holder.titleTv.setText(title);
        holder.messageTv.setText(message);
        holder.dateTv.setText(date.substring(4,10));
        holder.hourTv.setText(date.substring(11,16));
        holder.authorTv.setText(author);
    }

    @Override
    public int getItemCount() {
        return yearGroupPosts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView titleTv;
        private TextView messageTv;
        private TextView dateTv;
        private TextView hourTv;
        private TextView authorTv;

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
            authorTv= itemView.findViewById(R.id.tv_author);
        }
    }
}

