package com.example.asm.view.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;

import com.example.asm.R;
import com.example.asm.databinding.ActivityMainBinding;
import com.example.asm.view.main.calendar.CalendarFragment;
import com.example.asm.view.main.calendar.ListCourceFragment;
import com.example.asm.view.main.home.HomeFragment;
import com.example.asm.view.main.notification.NotificationFragment;
import com.example.asm.view.main.service.ServiceFragment;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replayFragment(new HomeFragment());
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.home) {
                replayFragment(new HomeFragment());
            } else if (itemId == R.id.calendar) {
                replayFragment(new ListCourceFragment());
            } else if (itemId == R.id.notification) {
                replayFragment(new NotificationFragment());
            } else if (itemId == R.id.service) {
                replayFragment(new ServiceFragment());
            }
            return true;
        });
    }

    private void replayFragment(Fragment fragment) {
        final FragmentManager fragmentManager = getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frm_main, fragment);
        fragmentTransaction.commit();
    }
}