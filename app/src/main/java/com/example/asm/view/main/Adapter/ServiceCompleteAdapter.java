package com.example.asm.view.main.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asm.R;
import com.example.asm.view.main.model.ServiceComplete;

import java.util.List;

public class ServiceCompleteAdapter extends RecyclerView.Adapter<ServiceCompleteAdapter.ViewHolder> {

    private List<ServiceComplete> itemList;

    public ServiceCompleteAdapter(List<ServiceComplete> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_service_complete, parent, false);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ServiceComplete item = itemList.get(position);

        holder.id_txt.setText(item.getId());
        holder.loai_txt.setText(item.getLoai());
        holder.confirm_txt.setText(item.getConfirm());
        holder.date_txt.setText(item.getDate());
        holder.thongbao_txt.setText(item.getThongbao());


        boolean isExpanded = item.isExpanded();
        holder.confirm_txt.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        holder.date_txt.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        holder.thongbao_txt.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        holder.date_dk.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        holder.tb_dk.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        holder.confirm_dk.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        holder.hd_dk.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        holder.linearLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        holder.btn_huy.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        if (isExpanded) {
            holder.img_arrow.setImageResource(R.drawable.ic_arrow_down);
        } else {
            holder.img_arrow.setImageResource(R.drawable.ic_arrow_right);
        }

        holder.img_arrow.setOnClickListener(v -> {
            item.setExpanded(!isExpanded);
            notifyItemChanged(position);
        });

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView id_txt,loai_txt,date_txt,confirm_txt,thongbao_txt,btn_huy,date_dk,confirm_dk,tb_dk,hd_dk;
        ImageView img_arrow;
        LinearLayout linearLayout;


        ViewHolder(View itemView) {
            super(itemView);
            id_txt = itemView.findViewById(R.id.id_txt);
            loai_txt = itemView.findViewById(R.id.loai_txt);
            date_txt = itemView.findViewById(R.id.date_txt);
            confirm_txt = itemView.findViewById(R.id.confirm_txt);
            thongbao_txt = itemView.findViewById(R.id.thongbao_txt);
            btn_huy = itemView.findViewById(R.id.btn_huy);
            img_arrow = itemView.findViewById(R.id.img_arrow);
            date_dk = itemView.findViewById(R.id.date_dk);
            confirm_dk = itemView.findViewById(R.id.confirm_dk);
            tb_dk = itemView.findViewById(R.id.tb_dk);
            hd_dk = itemView.findViewById(R.id.hd_dk);
            linearLayout = itemView.findViewById(R.id.linearLayout);
        }
    }
}
