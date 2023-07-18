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
import com.example.asm.view.main.model.Cource;
import com.example.asm.view.main.model.DateModel;

import java.util.ArrayList;

public class CourceAdapter extends RecyclerView.Adapter<CourceAdapter.CourceViewHolder>{

    private ArrayList<Cource> list;
    private Context context;

    public CourceAdapter(ArrayList<Cource> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public CourceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.itemcource,parent,false);
        return new CourceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourceViewHolder holder, int position) {
        holder.txtThoiGianBatDau.setText(list.get(position).getThoiGianBatDau()+"");
        holder.txtThoiGianKetThuc.setText(list.get(position).getThoiGianKetThuc()+"");
        holder.txtMon.setText(list.get(position).getMon()+" - "+ list.get(position).getMaMon());
        holder.txtPhong.setText(list.get(position).getPhong()+"");
        holder.txtGiangVien.setText(list.get(position).getGiangVien()+"");


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class CourceViewHolder extends RecyclerView.ViewHolder{
        TextView txtThoiGianBatDau, txtThoiGianKetThuc, txtMon,txtPhong, txtGiangVien;
        public CourceViewHolder(@NonNull View itemView) {
            super(itemView);
            txtThoiGianBatDau = itemView.findViewById(R.id.txtThoiGianBatDau);
            txtThoiGianKetThuc = itemView.findViewById(R.id.txtThoiGianKetThuc);
            txtMon = itemView.findViewById(R.id.txtMon);
            txtPhong = itemView.findViewById(R.id.txtPhong);
            txtGiangVien = itemView.findViewById(R.id.txtGiangVien);


        }
    }


}
