package com.example.licenta.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.licenta.Models.CommentModel;
import com.example.licenta.Models.PostModel;
import com.example.licenta.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.ViewHolder> {

    private List<CommentModel> comments;
    private Context context;

    public CommentsAdapter(List<CommentModel> comments, Context context) {
        this.comments = comments;
        this.context = context;
    }

    @NonNull
    @Override
    public CommentsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.row_comments, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CommentsAdapter.ViewHolder holder, int position) {

        String message = comments.get(position).getMessage();
        String date = comments.get(position).getDate().toString();
        String author = comments.get(position).getFullName();

        holder.messageTv.setText(message);
//        holder.dateTv.setText(date.substring(4,10));
//        holder.hourTv.setText(date.substring(11,16));
        holder.authorTv.setText(author);
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView authorTv;
        private TextView messageTv;
//        private TextView dateTv;
//        private TextView hourTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            initializeViews(itemView);
        }

        private void initializeViews(View itemView)
        {
            messageTv= itemView.findViewById(R.id.tv_text_comment_text);
//            dateTv= itemView.findViewById(R.id.tv_date);
//            hourTv= itemView.findViewById(R.id.tv_hour);
            authorTv= itemView.findViewById(R.id.tv_text_comment_name);
        }
    }
}
