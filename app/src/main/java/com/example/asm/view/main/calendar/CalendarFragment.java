package com.example.asm.view.main.calendar;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asm.R;
import com.example.asm.databinding.FragmentCalendarBinding;
import com.example.asm.view.main.adapter.CourceAdapter;
import com.example.asm.view.main.adapter.DateAdapter;
import com.example.asm.view.main.model.Cource;
import com.example.asm.view.main.model.DateModel;

import java.util.ArrayList;
import java.util.Date;

public class CalendarFragment extends Fragment {

    ArrayList<DateModel> listDate;
    ArrayList<Cource> listCource;
    RecyclerView recyclerViewDate, recyclerViewCource;


    private FragmentCalendarBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //binding = FragmentCalendarBinding.inflate(inflater,container, false);
        //View view = binding.getRoot();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);
        recyclerViewDate = view.findViewById(R.id.recyclerViewDate);
        recyclerViewCource = view.findViewById(R.id.recyclerViewCource);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initData();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL, false);
        recyclerViewDate.setLayoutManager(layoutManager);
        DateAdapter adapter = new DateAdapter(listDate, getContext());
        recyclerViewDate.setAdapter(adapter);

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getContext());
        recyclerViewCource.setLayoutManager(layoutManager2);
        CourceAdapter adapter2 = new CourceAdapter(listCource, getContext());
        recyclerViewCource.setAdapter(adapter2);

    }

    private void initData(){
        // danh sach Date
        listDate = new ArrayList<>();
        listDate.add(new DateModel(1, 21, "S"));
        listDate.add(new DateModel(2, 22, "M"));
        listDate.add(new DateModel(3, 23, "T"));
        listDate.add(new DateModel(4, 24, "W"));
        listDate.add(new DateModel(5, 25, "T"));
        listDate.add(new DateModel(6, 26, "F"));
        listDate.add(new DateModel(7, 27, "S"));

        //danh sach mon hoc
        listCource = new ArrayList<>();
        listCource.add(new Cource(1,"27/07/2003","T308 (Nha T)", "Phan Mem Quang Trung",
                "MOB403", "Android Networking", "MD17306",
                "channn3", "5", "17:30","19:30",""));
        listCource.add(new Cource(2,"28/07/2003","T308 (Nha T)", "Phan Mem Quang Trung",
                "MOB403", "Android Networking", "MD17306",
                "channn3", "5", "17:30","19:30",""));
        listCource.add(new Cource(3,"29/07/2003","T308 (Nha T)", "Phan Mem Quang Trung",
                "MOB403", "Android Networking", "MD17306",
                "channn3", "5", "17:30","19:30",""));
        listCource.add(new Cource(4,"30/07/2003","T308 (Nha T)", "Phan Mem Quang Trung",
                "MOB403", "Android Networking", "MD17306",
                "channn3", "5", "17:30","19:30",""));
        listCource.add(new Cource(5,"31/07/2003","T308 (Nha T)", "Phan Mem Quang Trung",
                "MOB403", "Android Networking", "MD17306",
                "channn3", "5", "17:30","19:30",""));
        listCource.add(new Cource(6,"01/08/2003","T308 (Nha T)", "Phan Mem Quang Trung",
                "MOB403", "Android Networking", "MD17306",
                "channn3", "5", "17:30","19:30",""));

    }
}