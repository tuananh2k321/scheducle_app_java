package com.example.asm.view.main.notification;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asm.R;
import com.example.asm.databinding.FragmentNotificationBinding;
import com.example.asm.model.News;
import com.example.asm.view.main.home.NewsAdapter;

import java.util.ArrayList;

public class NotificationFragment extends Fragment {

    private FragmentNotificationBinding binding;
    private ArrayList<News> notifyList;
    private NotificationAdapter notificationAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNotificationBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataInit();

        // news list
        LinearLayoutManager layoutManager =
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        binding.rcvNotification.setLayoutManager(layoutManager);
        notificationAdapter = new NotificationAdapter(requireContext(), notifyList);
        binding.rcvNotification.setAdapter(notificationAdapter);

    }

    private void dataInit() {
        notifyList = new ArrayList<>();
        notifyList.add(new News(1,
                "THÔNG BÁO ĐĂNG KÝ THỰC HIỆN DỰ ÁN TỐT NGHIỆP HỌC KỲ FALL 2023",
                "Phòng Đào tạo thông báo đến các bạn sinh viên có tên trong danh sách dự kiến " +
                        "làm Dự án tốt nghiệp học kỳ Fall 2023 về việc đăng ký nhóm và đề tài như sau: ",
                R.drawable.img_slider_1,
                true,
                1
        ));
        notifyList.add(new News(2,
                "THÔNG BÁO ĐĂNG KÝ THỰC HIỆN DỰ ÁN TỐT NGHIỆP HỌC KỲ FALL 2023",
                "Phòng Đào tạo thông báo đến các bạn sinh viên có tên trong danh sách dự kiến " +
                        "làm Dự án tốt nghiệp học kỳ Fall 2023 về việc đăng ký nhóm và đề tài như sau: ",
                R.drawable.img_avatar,
                false,
                1
        ));
        notifyList.add(new News(3,
                "THÔNG BÁO ĐĂNG KÝ THỰC HIỆN DỰ ÁN TỐT NGHIỆP HỌC KỲ FALL 2023",
                "Phòng Đào tạo thông báo đến các bạn sinh viên có tên trong danh sách dự kiến " +
                        "làm Dự án tốt nghiệp học kỳ Fall 2023 về việc đăng ký nhóm và đề tài như sau: ",
                R.drawable.img_slider_2,
                true,
                1
        ));
        notifyList.add(new News(4,
                "THÔNG BÁO ĐĂNG KÝ THỰC HIỆN DỰ ÁN TỐT NGHIỆP HỌC KỲ FALL 2023",
                "Phòng Đào tạo thông báo đến các bạn sinh viên có tên trong danh sách dự kiến " +
                        "làm Dự án tốt nghiệp học kỳ Fall 2023 về việc đăng ký nhóm và đề tài như sau: ",
                R.drawable.img_slider_1,
                true,
                1
        ));
        notifyList.add(new News(5,
                "THÔNG BÁO ĐĂNG KÝ THỰC HIỆN DỰ ÁN TỐT NGHIỆP HỌC KỲ FALL 2023",
                "Phòng Đào tạo thông báo đến các bạn sinh viên có tên trong danh sách dự kiến " +
                        "làm Dự án tốt nghiệp học kỳ Fall 2023 về việc đăng ký nhóm và đề tài như sau: ",
                R.drawable.img_slider_1,
                false,
                1
        ));
        notifyList.add(new News(6,
                "THÔNG BÁO ĐĂNG KÝ THỰC HIỆN DỰ ÁN TỐT NGHIỆP HỌC KỲ FALL 2023",
                "Phòng Đào tạo thông báo đến các bạn sinh viên có tên trong danh sách dự kiến " +
                        "làm Dự án tốt nghiệp học kỳ Fall 2023 về việc đăng ký nhóm và đề tài như sau: ",
                R.drawable.img_slider_1,
                false,
                1
        ));
    }
}