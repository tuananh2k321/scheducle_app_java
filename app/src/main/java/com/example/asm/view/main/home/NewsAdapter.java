package com.example.asm.view.main.home;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.asm.R;
import com.example.asm.model.Category;
import com.example.asm.model.News;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private Context context;
    private ArrayList<News> newsList;
    private Listener listener;

    public NewsAdapter(Context context, ArrayList<News> newsList, Listener listener){
        this.context = context;
        this.newsList = newsList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_news, parent, false);
        return new NewsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        if (newsList != null) {
            News currentItem = newsList.get(position);
            holder.tvTitle.setText(newsList.get(position).getTitle());
            holder.tvDetail.setText(newsList.get(position).getDetail());
            Glide.with(context)
                    .load(currentItem.getImg())
                    .fitCenter()
                    .into(holder.imgNews)
            ;

            holder.cvNews.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.e("ID news adapter", ""+currentItem.getId());
                    listener.getDetailNews(currentItem.getId());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (newsList != null) {
            return newsList.size();
            // Tiến hành các thao tác với ArrayList nếu nó không null
            // Ví dụ: lấy dữ liệu, thêm phần tử, xóa phần tử, ...
        } else {
            return 1;
        }
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle, tvDetail;
        private ImageView imgNews;
        private CardView cvNews;
        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDetail = itemView.findViewById(R.id.tv_detail);
            imgNews = itemView.findViewById(R.id.img_news);
            cvNews = itemView.findViewById(R.id.cv_news);
        }
    }
}
