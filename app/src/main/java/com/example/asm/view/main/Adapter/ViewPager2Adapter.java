package com.example.asm.view.main.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.asm.view.main.fragment.LichHocFragment;
import com.example.asm.view.main.fragment.LichThiFragment;

public class ViewPager2Adapter extends FragmentStateAdapter {
    public ViewPager2Adapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }
//    public ViewPager2Adapter(@NonNull FragmentActivity fragmentActivity) {
//        super(fragmentActivity);
//    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position == 0)
            return new LichHocFragment();
        return new LichThiFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
