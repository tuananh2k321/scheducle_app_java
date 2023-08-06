package com.example.asm.view.main.calendar;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asm.R;
import com.example.asm.databinding.FragmentCalendarBinding;

import com.example.asm.view.main.Adapter.ViewPager2Adapter;
import com.google.android.material.tabs.TabLayout;

public class CalendarFragment extends Fragment {


    ViewPager2 viewPager2;
    TabLayout tabLayout;

    ViewPager2Adapter viewPager2Adapter;


    private FragmentCalendarBinding binding;
    //private ViewPagerAdapter viewPagerAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //binding = FragmentCalendarBinding.inflate(inflater,container, false);
        //View view = binding.getRoot();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);

        viewPager2 = view.findViewById(R.id.viewPager);
        tabLayout = view.findViewById(R.id.tabLayout);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

        viewPager2Adapter = new ViewPager2Adapter(fragmentManager, getActivity().getLifecycle());
        viewPager2.setAdapter(viewPager2Adapter);

        tabLayout.addTab(tabLayout.newTab().setText("Lịch học"));
        tabLayout.addTab(tabLayout.newTab().setText("Lịch thi"));


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));

            }
        });


    }



}