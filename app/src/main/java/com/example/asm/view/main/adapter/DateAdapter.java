package com.example.asm.view.main.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asm.R;
import com.example.asm.view.main.model.DateModel;
import com.example.asm.view.main.recycleview.IRecycleview;

import java.util.ArrayList;

public class DateAdapter extends RecyclerView.Adapter<DateAdapter.DateViewHolder>{

    private final IRecycleview iRecycleview;
    private ArrayList<DateModel> list;
    private static Context context;

    public DateAdapter(ArrayList<DateModel> list, Context context, IRecycleview iRecycleview) {
        this.list = list;
        this.context = context;
        this.iRecycleview = iRecycleview;
    }

    @NonNull
    @Override
    public DateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.itemdate,parent,false);
        return new DateViewHolder(view, iRecycleview);
    }

    @Override
    public void onBindViewHolder(@NonNull DateViewHolder holder, int position) {
        DateModel currentItem = list.get(position);
        holder.txtNgay.setText(list.get(position).getNgay()+"");
        holder.txtThu.setText(list.get(position).getThu()+"");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class DateViewHolder extends RecyclerView.ViewHolder{
        TextView txtThu, txtNgay;
        LinearLayout lnlDate;
        public DateViewHolder(@NonNull View itemView, IRecycleview iRecycleview) {
            super(itemView);
            txtNgay = itemView.findViewById(R.id.txtNgay);
            txtThu = itemView.findViewById(R.id.txtThu);
            lnlDate = itemView.findViewById(R.id.lnlDate);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (iRecycleview != null){
                        int pos = getAdapterPosition();
                        int seleted = -1;
                        seleted = pos;

                        if(pos != RecyclerView.NO_POSITION){
                            iRecycleview.onItemClickDate(pos);
                        }

                    }
                }
            });
        }
    }


}
