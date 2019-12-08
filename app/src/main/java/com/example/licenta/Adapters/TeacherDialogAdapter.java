package com.example.licenta.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.licenta.Models.TeacherModel;
import com.example.licenta.R;

import java.util.List;

public class TeacherDialogAdapter extends BaseAdapter {

    private List<TeacherModel> objects;
    private LayoutInflater layoutInflater;

    public TeacherDialogAdapter(Context context, List<TeacherModel> objects) {
        this.objects = objects;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.row_teacher_dialog, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.simpleItemDialog = convertView.findViewById(R.id.tv_row_teacher_dialog);
        holder.simpleItemDialog.setText(objects.get(position).getName());
        return convertView;
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView simpleItemDialog;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
