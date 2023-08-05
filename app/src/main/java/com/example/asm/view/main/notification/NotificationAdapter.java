package com.example.asm.view.main.notification;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.asm.R;
import com.example.asm.model.News;
import com.example.asm.view.main.home.NewsAdapter;
import com.example.asm.view.main.home.NewsDetailActivity;

import java.util.ArrayList;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>{

    private Context context;
    private ArrayList<News> notifyList;

    public NotificationAdapter(Context context, ArrayList<News> notifyList){
        this.context = context;
        this.notifyList = notifyList;
    }
    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_notification, parent, false);
        return new NotificationViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationViewHolder holder, int position) {
        News currentItem = notifyList.get(position);

        holder.tvTitle.setText(currentItem.getTitle());
        holder.tvDetail.setText(currentItem.getDetail());
        Glide.with(context)
                .load(currentItem.getImg())
                .fitCenter()
                .into(holder.imgNews)
        ;

        if (notifyList.get(position).getSeen() == 0) {
            holder.cvNews.setCardBackgroundColor(ContextCompat.getColor(context, R.color.blue));
        }
        holder.cvNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (notifyList != null) {
                    currentItem.setSeen(1);
                    holder.cvNews.setCardBackgroundColor(ContextCompat.getColor(context, R.color.white));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (notifyList != null) {
        return notifyList.size();}
        else {
            return 0;
        }
    }

    public static class NotificationViewHolder extends RecyclerView.ViewHolder{
        private TextView tvTitle, tvDetail;
        private ImageView imgNews;
        private CardView cvNews;
        public NotificationViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDetail = itemView.findViewById(R.id.tv_detail);
            imgNews = itemView.findViewById(R.id.img_news);
            cvNews = itemView.findViewById(R.id.cv_news);
        }
    }
}
