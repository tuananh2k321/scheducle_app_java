package com.example.asm.view.main.calendar;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asm.R;
import com.example.asm.databinding.FragmentCalendarBinding;
import com.example.asm.view.main.adapter.CourceAdapter;
import com.example.asm.view.main.adapter.DateAdapter;
import com.example.asm.view.main.adapter.ViewPager2Adapter;
import com.example.asm.view.main.fragment.LichHocFragment;
import com.example.asm.view.main.fragment.LichThiFragment;
import com.example.asm.view.main.model.Cource;
import com.example.asm.view.main.model.DateModel;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

        viewPager2Adapter = new ViewPager2Adapter(fragmentManager,getActivity().getLifecycle());
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



//        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
//            @Override
//            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
//                if (position == 0){
//                    tab.setText("Lịch học");
//                }else {
//                    tab.setText("Lịch thi");
//                }
//            }
//        }).attach();

        

        //initView();


    }

//    private void initView() {
//        viewPagerAdapter = new ViewPagerAdapter(this.getActivity().getSupportFragmentManager(),
//                this.getActivity().getLifecycle());
//        viewPagerAdapter.addFragment(new LichHocFragment(), "Lịch học");
//        viewPagerAdapter.addFragment(new LichThiFragment(), "Lịch thi");
//        viewPager2.setAdapter(viewPagerAdapter);
//        viewPager2.setOffscreenPageLimit(1);
//
////        new TabLayoutMediator(tabLayout, viewPager2,
////                (tab, position) -> {
////                    tab.setText(viewPagerAdapter.fragmentTitleList.get(position));
////                }).attach();
//
//        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
//            @Override
//            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
//                switch (position){
//                    case 1:
//                        tab.setText("Lịch Học");
//                        break;
//                    case 2:
//                        tab.setText("Lịch Thi");
//                        break;
//                }
//            }
//        }).attach();
//
//        for (int i = 0; i < tabLayout.getTabCount(); i++){
//            TextView tv = (TextView) LayoutInflater.from(this.getActivity())
//                    .inflate(R.layout.custom_tab, null);
//            tabLayout.getTabAt(i).setCustomView(tv);
//        }
//
//    }

    class ViewPagerAdapter extends FragmentStateAdapter{

        private final List<Fragment> fragmentList = new ArrayList<>();
        private final List<String> fragmentTitleList = new ArrayList<>();


        public ViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
        }

        public void addFragment(Fragment fragment, String title){
            fragmentList.add(fragment);
            fragmentTitleList.add(title);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getItemCount() {
            return fragmentList.size();
        }
    }



}