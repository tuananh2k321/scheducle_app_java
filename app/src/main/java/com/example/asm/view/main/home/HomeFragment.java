package com.example.asm.view.main.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.asm.R;
import com.example.asm.databinding.FragmentHomeBinding;
import com.example.asm.model.Category;
import com.example.asm.model.News;

import java.sql.Array;
import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    // slider
    private ArrayList<SlideModel> sliderList;

    // category
    private ArrayList<Category> categoryList;
    private CategoryAdapter categoryAdapter;

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

        // slider
        binding.imageSlider.setImageList(sliderList);

        // category
        LinearLayoutManager layoutManager =
                new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        binding.rcvCategory.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(getContext(), categoryList);
        binding.rcvCategory.setAdapter(categoryAdapter);

        // news
        LinearLayoutManager layoutManager1 =
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        binding.rcvNews.setLayoutManager(layoutManager1);
        newsAdapter = new NewsAdapter(getContext(), newsList);
        binding.rcvNews.setAdapter(newsAdapter);
    }

    private void initData() {
        sliderList = new ArrayList<>();
        sliderList.add(new SlideModel(R.drawable.img_slider_1, ScaleTypes.CENTER_CROP));
        sliderList.add(new SlideModel(R.drawable.img_slider_2, ScaleTypes.CENTER_CROP));
        sliderList.add(new SlideModel(R.drawable.img_avatar, ScaleTypes.CENTER_CROP));

        categoryList = new ArrayList<>();
        categoryList.add(new Category(1,"Học tập", R.drawable.icons8_learn_28, "#c5e1a5"));
        categoryList.add(new Category(2, "Hoạt động", R.drawable.icons8_activity_28, "#e1bee7"));
        categoryList.add(new Category(3, "Học phí", R.drawable.icons8_tuition_fee_28, "#b3e5fc"));

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