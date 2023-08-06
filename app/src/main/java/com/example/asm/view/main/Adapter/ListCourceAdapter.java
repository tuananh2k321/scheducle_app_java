package com.example.asm.view.main.Adapter;

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

import java.util.ArrayList;

public class ListCourceAdapter extends RecyclerView.Adapter<ListCourceAdapter.CourceViewHolder>{

    private ArrayList<Cource> list;
    private Context context;

    public ListCourceAdapter(ArrayList<Cource> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public CourceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.itemlistcource,parent,false);
        return new CourceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourceViewHolder holder, int position) {
        holder.txtThoiGian.setText(list.get(position).getThoiGianBatDau()+" - "+list.get(position).getThoiGianKetThuc());
        holder.txtNgay.setText(list.get(position).getNgay()+"");
        holder.txtMon.setText(list.get(position).getMon()+" - "+ list.get(position).getMaMon());
        holder.txtPhong.setText("Phòng "+list.get(position).getPhong()+"");


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class CourceViewHolder extends RecyclerView.ViewHolder{
        TextView txtThoiGian, txtMon,txtPhong, txtNgay;
        public CourceViewHolder(@NonNull View itemView) {
            super(itemView);
            txtThoiGian = itemView.findViewById(R.id.txtThoiGian);
            txtMon = itemView.findViewById(R.id.txtMon);
            txtPhong = itemView.findViewById(R.id.txtPhong);
            txtNgay = itemView.findViewById(R.id.txtNgay);


        }
    }


}
