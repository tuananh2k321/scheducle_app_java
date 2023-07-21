package com.example.asm.view.main.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asm.R;
import com.example.asm.view.main.model.Cource;
import com.example.asm.view.main.model.DateModel;
import com.example.asm.view.main.recycleview.IRecycleview;

import java.util.ArrayList;

public class CourceAdapter extends RecyclerView.Adapter<CourceAdapter.CourceViewHolder>{

    private final IRecycleview iRecycleview;


    private ArrayList<Cource> list;
    private Context context;

    public CourceAdapter(ArrayList<Cource> list, Context context, IRecycleview iRecycleview) {
        this.list = list;
        this.context = context;
        this.iRecycleview = iRecycleview;

    }

    @NonNull
    @Override
    public CourceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.itemcource,parent,false);
        return new CourceViewHolder(view, iRecycleview);
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
        private TextView txtThoiGianBatDau, txtThoiGianKetThuc, txtMon,txtPhong, txtGiangVien;
        public CourceViewHolder(@NonNull View itemView, IRecycleview iRecycleview) {
            super(itemView);
            txtThoiGianBatDau = itemView.findViewById(R.id.txtThoiGianBatDau);
            txtThoiGianKetThuc = itemView.findViewById(R.id.txtThoiGianKetThuc);
            txtMon = itemView.findViewById(R.id.txtMon);
            txtPhong = itemView.findViewById(R.id.txtPhong);
            txtGiangVien = itemView.findViewById(R.id.txtGiangVien);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (iRecycleview != null){
                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION){
                            iRecycleview.onItemClic(pos);
                        }
                    }
                }
            });

        }
    }




}

