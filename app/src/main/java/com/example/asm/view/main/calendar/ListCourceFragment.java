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

import com.example.asm.view.main.adapter.CourceAdapter;
import com.example.asm.view.main.adapter.DateAdapter;
import com.example.asm.view.main.adapter.ListCourceAdapter;
import com.example.asm.view.main.model.Cource;

import java.util.ArrayList;

public class ListCourceFragment extends Fragment {
    RecyclerView recyclerViewCource;

    ArrayList<Cource> listCource;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_cource, container, false);
        recyclerViewCource = view.findViewById(R.id.recyclerViewCource);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initData();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerViewCource.setLayoutManager(layoutManager);
        ListCourceAdapter adapter = new ListCourceAdapter(listCource, getContext());
        recyclerViewCource.setAdapter(adapter);

    }

    private void initData(){

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