package com.example.androidninjaworkspace.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.androidninjaworkspace.R;
import com.example.androidninjaworkspace.models.models;

import java.util.ArrayList;

public class RvRowAdapter extends RecyclerView.Adapter<RvRowAdapter.ViewHolder> {

    private Context context;
    private ArrayList<models> dataList;


    public RvRowAdapter(Context context, ArrayList<models> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtFirstName.setText(dataList.get(position).getFirst_name());
        holder.txtEmail.setText(dataList.get(position).getEmail());
        Glide.with(context).load(dataList.get(position).getAvatar()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView txtFirstName,txtEmail;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            txtFirstName = itemView.findViewById(R.id.txtFirstName);
            txtEmail = itemView.findViewById(R.id.txtEmail);


        }
    }
}
