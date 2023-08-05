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
import com.example.asm.view.main.model.Schedules;
import com.example.asm.view.main.recycleview.IRecycleview;

import java.util.List;

public class CourceAdapter extends RecyclerView.Adapter<CourceAdapter.CourceViewHolder>{

    private final IRecycleview iRecycleview;


    private List<Schedules> list;
    private Context context;

    public CourceAdapter(List<Schedules> list, Context context, IRecycleview iRecycleview) {
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
        holder.txtThoiGianBatDau.setText(list.get(position).getTime()+"");
        holder.txtMon.setText(list.get(position).getCourse_name()+" - "+ list.get(position).getCourse_id());
        holder.txtPhong.setText(list.get(position).getRoom()+"");
        holder.txtGiangVien.setText(list.get(position).getTeacher_name()+"");



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class CourceViewHolder extends RecyclerView.ViewHolder{
        private TextView txtThoiGianBatDau, txtMon,txtPhong, txtGiangVien;
        public CourceViewHolder(@NonNull View itemView, IRecycleview iRecycleview) {
            super(itemView);
            txtThoiGianBatDau = itemView.findViewById(R.id.txtThoiGianBatDau);
            txtMon = itemView.findViewById(R.id.txtMon);
            txtPhong = itemView.findViewById(R.id.txtPhong);
            txtGiangVien = itemView.findViewById(R.id.txtGiangVien);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (iRecycleview != null){
                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION){
                            iRecycleview.onItemClickSchedule(pos);
                        }
                    }
                }
            });

        }
    }




}

