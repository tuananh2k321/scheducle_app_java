package com.example.asm.view.main.home;

import android.content.Context;
import android.graphics.Color;
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

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>{

    private Context context;
    private ArrayList<Category> categoryList;
    private Listener categoryListener;


    public CategoryAdapter(Context context,ArrayList<Category> categoryList, Listener categoryListener) {
        this.context = context;
        this.categoryList = categoryList;
        this.categoryListener = categoryListener;
    }


    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
         Category currentItem = categoryList.get(position);
         holder.tv_category.setText(currentItem.getName());
         Glide.with(context)
                    .load(currentItem.getImg())
                    .fitCenter()
                    .into(holder.img_category)
                 ;
         holder.cv_background.setCardBackgroundColor(Color.parseColor(currentItem.getColor()));

         holder.cv_background.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Log.e("ID category", ""+currentItem.getId());
                 categoryListener.getListNewsById(currentItem.getId(), currentItem.getName());

             }
         });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_category;
        private ImageView img_category;
        private CardView cv_background;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_category = itemView.findViewById(R.id.tv_category);
            img_category = itemView.findViewById(R.id.img_category);
            cv_background = itemView.findViewById(R.id.background);
        }
    }
}
