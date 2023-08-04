package com.example.asm.view.main.home;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.asm.R;
import com.example.asm.api_res.CategoryRes;
import com.example.asm.api_res.NewsRes;
import com.example.asm.databinding.FragmentHomeBinding;
import com.example.asm.model.Category;
import com.example.asm.model.News;
import com.example.asm.retrofit.IRetrofit;
import com.example.asm.retrofit.RetrofitHelper;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment implements Listener {

    private FragmentHomeBinding binding;

    // retrofit
    private IRetrofit iRetrofit;

    // slider
    private ArrayList<SlideModel> sliderList;

    // category
    private ArrayList<Category> categoryList;
    private CategoryAdapter categoryAdapter;

    // news
    private ArrayList<News> newsList;
    private NewsAdapter newsAdapter;

    SharedPreferences sharedPreferences;
    private TextView tv_name_student, tv_email_student;
    private ImageView img_user;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();

        // retrofit
        iRetrofit = RetrofitHelper.createService(IRetrofit.class);

        // slider
        binding.imageSlider.setImageList(sliderList);

        // category
        LinearLayoutManager layoutManager =
                new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        binding.rcvCategory.setLayoutManager(layoutManager);
        iRetrofit.getAllCategory().enqueue(categoryResCallback);


        // news
        LinearLayoutManager layoutManager1 =
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        binding.rcvNews.setLayoutManager(layoutManager1);
        iRetrofit.getAllNews().enqueue(newsResCallback);

        tv_name_student = view.findViewById(R.id.tv_name_student);
        tv_email_student = view.findViewById(R.id.tv_email_student);

        sharedPreferences = getContext().getSharedPreferences("data_user", Context.MODE_PRIVATE);

        tv_name_student.setText(sharedPreferences.getString("name_user", null));
        tv_email_student.setText(sharedPreferences.getString("email_user", null));

        img_user = view.findViewById(R.id.img_user);
        Glide.with(this).load(sharedPreferences.getString("img_user",null)).into(img_user);

    }

    private Callback<CategoryRes> categoryResCallback = new Callback<CategoryRes>() {
        @Override
        public void onResponse(Call<CategoryRes> call, Response<CategoryRes> response) {
            CategoryRes categoryRes = response.body();
            if (categoryRes != null) {
                if (categoryRes.getStatus()) {
                    Log.e("categoryResCallback", "CategoryRes: " + "success");
                    Log.e("categoryResCallback", "CategoryRes: " + categoryRes.toString());
                    categoryList = categoryRes.getCategories();
                    categoryAdapter = new CategoryAdapter(getContext(), categoryList, HomeFragment.this);
                    binding.rcvCategory.setAdapter(categoryAdapter);
                } else {
                    Log.e("categoryResCallback", "CategoryRes: " + "fail");
                }
            }
        }

        @Override
        public void onFailure(Call<CategoryRes> call, Throwable t) {
            Log.e("categoryResCallback", "onFailure: " + t.getMessage());
        }
    };

    private Callback<NewsRes> newsResCallback = new Callback<NewsRes>() {
        @Override
        public void onResponse(Call<NewsRes> call, Response<NewsRes> response) {
            NewsRes newsRes = response.body();
            if (newsRes != null) {
                if (newsRes.getStatus()) {
                    Log.e("newsResCallback", "newsResCallback: " + "success");
                    Log.e("newsResCallback", "newsResCallback: " + newsRes.toString());
                    newsList = newsRes.getNews();
                    newsAdapter = new NewsAdapter(getContext(), newsList, HomeFragment.this);
                    binding.rcvNews.setAdapter(newsAdapter);
                } else {
                    Log.e("newsResCallback", "newsResCallback: " + "fail");
                }
            }
        }

        @Override
        public void onFailure(Call<NewsRes> call, Throwable t) {
            Log.e("newsResCallback", "onFailure: " + t.getMessage());
        }
    };

    private void initData() {
        sliderList = new ArrayList<>();
        sliderList.add(new SlideModel(R.drawable.fpoly1, ScaleTypes.CENTER_CROP));
        sliderList.add(new SlideModel(R.drawable.fpoly2, ScaleTypes.CENTER_CROP));
        sliderList.add(new SlideModel(R.drawable.fpoly3, ScaleTypes.CENTER_CROP));

        categoryList = new ArrayList<>();
//        categoryList.add(new Category(1,"Học tập", R.drawable.icons8_learn_28, "#c5e1a5"));
//        categoryList.add(new Category(2, "Hoạt động", R.drawable.icons8_activity_28, "#e1bee7"));
//        categoryList.add(new Category(3, "Học phí", R.drawable.icons8_tuition_fee_28, "#b3e5fc"));

        newsList = new ArrayList<>();

    }

    @Override
    public void getListNewsById(int id, String name) {
        Intent intent = new Intent(getContext(), NewsListActivity.class);
        intent.putExtra("categoryId", id);
        intent.putExtra("categoryName", name);
        startActivity(intent);
    }

    @Override
    public void getDetailNews(int id) {
        Intent intent = new Intent(getContext(), NewsDetailActivity.class);
        intent.putExtra("newsId", id);
        startActivity(intent);
    }
}