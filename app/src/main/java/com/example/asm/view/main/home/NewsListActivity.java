package com.example.asm.view.main.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.asm.R;
import com.example.asm.databinding.ActivityNewsListBinding;
import com.example.asm.model.News;

import java.util.ArrayList;

public class NewsListActivity extends AppCompatActivity {
    private ActivityNewsListBinding binding;
    private ArrayList<News> newsList;
    private NewsAdapter newsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewsListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dataInit();

        // back
        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // news list
        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.rcvNews.setLayoutManager(layoutManager);
        newsAdapter = new NewsAdapter(this, newsList);
        binding.rcvNews.setAdapter(newsAdapter);
    }

    private void dataInit() {
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