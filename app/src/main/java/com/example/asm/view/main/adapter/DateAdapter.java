package com.example.asm.view.main.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asm.R;
import com.example.asm.view.main.model.DateModel;

import java.util.ArrayList;

public class DateAdapter extends RecyclerView.Adapter<DateAdapter.DateViewHolder>{

    private ArrayList<DateModel> list;
    private Context context;

    public DateAdapter(ArrayList<DateModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public DateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.itemdate,parent,false);
        return new DateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DateViewHolder holder, int position) {
        holder.txtNgay.setText(list.get(position).getNgay()+"");
        holder.txtThu.setText(list.get(position).getThu()+"");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class DateViewHolder extends RecyclerView.ViewHolder{
        TextView txtThu, txtNgay;
        public DateViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNgay = itemView.findViewById(R.id.txtNgay);
            txtThu = itemView.findViewById(R.id.txtThu);

        }
    }


}
