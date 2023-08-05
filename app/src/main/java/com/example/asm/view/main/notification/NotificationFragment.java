package com.example.asm.view.main.notification;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asm.R;
import com.example.asm.api_res.NewsRes;
import com.example.asm.databinding.FragmentNotificationBinding;
import com.example.asm.model.News;
import com.example.asm.retrofit.IRetrofit;
import com.example.asm.retrofit.RetrofitHelper;
import com.example.asm.view.main.home.HomeFragment;
import com.example.asm.view.main.home.NewsAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationFragment extends Fragment {

    private FragmentNotificationBinding binding;
    private ArrayList<News> notifyList  ;
    // retrofit
    private IRetrofit iRetrofit;
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
        // retrofit
        iRetrofit = RetrofitHelper.createService(IRetrofit.class);

        // news list
        LinearLayoutManager layoutManager =
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        binding.rcvNotification.setLayoutManager(layoutManager);

        iRetrofit.getNotification("ps24524").enqueue(notifyResCallback);
    }

    private Callback<NewsRes> notifyResCallback = new Callback<NewsRes>() {
        @Override
        public void onResponse(Call<NewsRes> call, Response<NewsRes> response) {
            NewsRes newsRes = response.body();
            if (newsRes != null) {
                if (newsRes.getStatus()) {
                    Log.e("notifyResCallback", "notifyResCallback: " + "success");
                    Log.e("notifyResCallback", "notifyResCallback: " + newsRes.toString());
                    notifyList = newsRes.getNotification();
                    notificationAdapter = new NotificationAdapter(requireContext(), notifyList);
                    binding.rcvNotification.setAdapter(notificationAdapter);
                } else {
                    Log.e("notifyResCallback", "notifyResCallback: " + "fail");
                }
            }
        }

        @Override
        public void onFailure(Call<NewsRes> call, Throwable t) {
            Log.e("notifyResCallback", "onFailure: " + t.getMessage());
        }
    };


}