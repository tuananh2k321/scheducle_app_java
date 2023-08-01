package com.example.asm.view.main.home;

import android.content.Context;
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
import android.widget.TextView;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.asm.R;
import com.example.asm.api_res.CategoryRes;
import com.example.asm.databinding.FragmentHomeBinding;
import com.example.asm.model.Category;
import com.example.asm.model.News;
import com.example.asm.retrofit.IRetrofit;
import com.example.asm.retrofit.RetrofitHelper;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    // retrofit
    private IRetrofit iRetrofit;

    // slider
    private ArrayList<SlideModel> sliderList;

    // category
    private ArrayList<Category> categoryList;
    private CategoryAdapter categoryAdapter;

    TextView tv_name_student, tv_email_student;
    SharedPreferences sharedPreferences;




    // news
    private ArrayList<News> newsList;
    private NewsAdapter newsAdapter;
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
        newsAdapter = new NewsAdapter(getContext(), newsList);
        binding.rcvNews.setAdapter(newsAdapter);

        tv_name_student= view.findViewById(R.id.tv_name_student);
        tv_email_student= view.findViewById(R.id.tv_email_student);

        sharedPreferences = getContext().getSharedPreferences("data_user", Context.MODE_PRIVATE);

        String name = sharedPreferences.getString("name_user", null);
        String email = sharedPreferences.getString("email_user", null);
        String student_code = sharedPreferences.getString("student_code", null);

        if (name != null || email != null){
            tv_name_student.setText(name);
            tv_email_student.setText(email);
        }



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
                    categoryAdapter = new CategoryAdapter(getContext(), categoryList);
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

    private void initData() {
        sliderList = new ArrayList<>();
        sliderList.add(new SlideModel(R.drawable.img_slider_1, ScaleTypes.CENTER_CROP));
        sliderList.add(new SlideModel(R.drawable.img_slider_2, ScaleTypes.CENTER_CROP));
        sliderList.add(new SlideModel(R.drawable.img_avatar, ScaleTypes.CENTER_CROP));

        categoryList = new ArrayList<>();
//        categoryList.add(new Category(1,"Học tập", R.drawable.icons8_learn_28, "#c5e1a5"));
//        categoryList.add(new Category(2, "Hoạt động", R.drawable.icons8_activity_28, "#e1bee7"));
//        categoryList.add(new Category(3, "Học phí", R.drawable.icons8_tuition_fee_28, "#b3e5fc"));

        newsList = new ArrayList<>();
        newsList.add(new News(1,
                "THÔNG BÁO ĐĂNG KÝ THỰC HIỆN DỰ ÁN TỐT NGHIỆP HỌC KỲ FALL 2023",
                "Phòng Đào tạo thông báo đến các bạn sinh viên có tên trong danh sách dự kiến " +
                        "làm Dự án tốt nghiệp học kỳ Fall 2023 về việc đăng ký nhóm và đề tài như sau: ",
                R.drawable.img_slider_1,
                true,
                1
        ));
        newsList.add(new News(2,
                "THÔNG BÁO ĐĂNG KÝ THỰC HIỆN DỰ ÁN TỐT NGHIỆP HỌC KỲ FALL 2023",
                "Phòng Đào tạo thông báo đến các bạn sinh viên có tên trong danh sách dự kiến " +
                        "làm Dự án tốt nghiệp học kỳ Fall 2023 về việc đăng ký nhóm và đề tài như sau: ",
                R.drawable.img_avatar,
                false,
                1
        ));
        newsList.add(new News(3,
                "THÔNG BÁO ĐĂNG KÝ THỰC HIỆN DỰ ÁN TỐT NGHIỆP HỌC KỲ FALL 2023",
                "Phòng Đào tạo thông báo đến các bạn sinh viên có tên trong danh sách dự kiến " +
                        "làm Dự án tốt nghiệp học kỳ Fall 2023 về việc đăng ký nhóm và đề tài như sau: ",
                R.drawable.img_slider_2,
                true,
                1
        ));
        newsList.add(new News(4,
                "THÔNG BÁO ĐĂNG KÝ THỰC HIỆN DỰ ÁN TỐT NGHIỆP HỌC KỲ FALL 2023",
                "Phòng Đào tạo thông báo đến các bạn sinh viên có tên trong danh sách dự kiến " +
                        "làm Dự án tốt nghiệp học kỳ Fall 2023 về việc đăng ký nhóm và đề tài như sau: ",
                R.drawable.img_slider_1,
                true,
                1
        ));
        newsList.add(new News(5,
                "THÔNG BÁO ĐĂNG KÝ THỰC HIỆN DỰ ÁN TỐT NGHIỆP HỌC KỲ FALL 2023",
                "Phòng Đào tạo thông báo đến các bạn sinh viên có tên trong danh sách dự kiến " +
                        "làm Dự án tốt nghiệp học kỳ Fall 2023 về việc đăng ký nhóm và đề tài như sau: ",
                R.drawable.img_slider_1,
                false,
                1
        ));
        newsList.add(new News(6,
                "THÔNG BÁO ĐĂNG KÝ THỰC HIỆN DỰ ÁN TỐT NGHIỆP HỌC KỲ FALL 2023",
                "Phòng Đào tạo thông báo đến các bạn sinh viên có tên trong danh sách dự kiến " +
                        "làm Dự án tốt nghiệp học kỳ Fall 2023 về việc đăng ký nhóm và đề tài như sau: ",
                R.drawable.img_slider_1,
                false,
                1
        ));
    }
}