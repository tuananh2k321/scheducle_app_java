package com.example.asm.view.main.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asm.R;
import com.example.asm.view.main.model.ServiceComplete;

import java.util.List;

public class ServiceCompleteAdapter3 extends RecyclerView.Adapter<ServiceCompleteAdapter3.ViewHolder> {

    private List<ServiceComplete> itemList;

    public ServiceCompleteAdapter3(List<ServiceComplete> itemList) {
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

        holder.id_txt.setText(String.valueOf(itemList.get(position).getId()));
        holder.loai_txt.setText(itemList.get(position).getService());
        holder.confirm_txt.setText(String.valueOf(itemList.get(position).getQuantity()));
        holder.date_txt.setText(itemList.get(position).getPhoneNumber());
        holder.thongbao_txt.setText(itemList.get(position).getMucdich());
        holder.tv_confirm.setText(itemList.get(position).getConfirm());


        boolean isExpanded = itemList.get(position).isExpanded();
        holder.confirm_txt.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        holder.date_txt.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        holder.date_dk.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        holder.confirm_dk.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        holder.linearLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);






        if (isExpanded) {
            holder.img_arrow.setImageResource(R.drawable.ic_arrow_down);
            if(itemList.get(position).getService().equals("Giấy xác nhận sinh viên")){
                holder.hd_dk.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
                holder.tv_confirm.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
                holder.tb_dk.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
                holder.thongbao_txt.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
            }else {
                holder.hd_dk.setVisibility(isExpanded ? View.GONE : View.VISIBLE);
                holder.tv_confirm.setVisibility(isExpanded ? View.GONE : View.VISIBLE);
                holder.tb_dk.setVisibility(isExpanded ? View.GONE : View.VISIBLE);
                holder.thongbao_txt.setVisibility(isExpanded ? View.GONE : View.VISIBLE);
            }
        } else {
            holder.img_arrow.setImageResource(R.drawable.ic_arrow_right);
           
        }

        holder.img_arrow.setOnClickListener(v -> {
            itemList.get(position).setExpanded(!isExpanded);
            notifyItemChanged(position);
        });

    }

    @Override
    public int getItemCount() {
        if(itemList == null) return  0;
        return itemList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView id_txt,loai_txt,date_txt,confirm_txt,thongbao_txt,date_dk,confirm_dk,tb_dk,hd_dk,tv_confirm;
        ImageView img_arrow;
        LinearLayout linearLayout;


        ViewHolder(View itemView) {
            super(itemView);
            id_txt = itemView.findViewById(R.id.id_txt);
            loai_txt = itemView.findViewById(R.id.loai_txt);
            date_txt = itemView.findViewById(R.id.date_txt);
            date_dk = itemView.findViewById(R.id.date_dk);
            confirm_txt = itemView.findViewById(R.id.confirm_txt);
            confirm_dk = itemView.findViewById(R.id.confirm_dk);
            thongbao_txt = itemView.findViewById(R.id.thongbao_txt);
            tb_dk = itemView.findViewById(R.id.tb_dk);
            img_arrow = itemView.findViewById(R.id.img_arrow);
            hd_dk = itemView.findViewById(R.id.hd_dk);
            tv_confirm = itemView.findViewById(R.id.tv_confirm);
            linearLayout = itemView.findViewById(R.id.linearLayout);
        }
    }
}
