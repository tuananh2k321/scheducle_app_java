package com.example.asm.view.main.fragment;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.StackView;
import android.widget.Toast;

import com.example.asm.R;
import com.example.asm.view.main.adapter.CourceAdapter;
import com.example.asm.view.main.adapter.DateAdapter;
import com.example.asm.view.main.adapter.StackAdapter;
import com.example.asm.view.main.model.Cource;
import com.example.asm.view.main.model.DateModel;
import com.example.asm.view.main.recycleview.IRecycleview;

import java.util.ArrayList;

public class LichThiFragment extends Fragment implements IRecycleview {
    ArrayList<DateModel> listDate;
    ArrayList<Cource> listCource;
    RecyclerView recyclerViewDate, recyclerViewCource;
    StackView stackView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lich_thi, container, false);
        recyclerViewDate = view.findViewById(R.id.recyclerViewDate);
        //recyclerViewCource = view.findViewById(R.id.recyclerViewCource);
        stackView = view.findViewById(R.id.stackView);

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

//        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getContext());
//        stackView.setLayoutManager(layoutManager2);
        //CourceAdapter adapter2 = new CourceAdapter(listCource, getContext(), this);
        StackAdapter stackAdapter = new StackAdapter(getContext(),R.layout.itemcource_stack,listCource);
        stackView.setAdapter(stackAdapter);

        stackView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int index = position;
                Toast.makeText(getContext(), "Selected contact: "+ index, Toast.LENGTH_LONG).show();
                getAllCource(Gravity.CENTER);
            }
        });
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

    @Override
    public void onItemClic(int position) {
        Toast.makeText(getContext(), "Click item", Toast.LENGTH_LONG);
        getAllCource(Gravity.CENTER);

    }

    private void getAllCource(int gravity){
        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_cource);

        Window window = dialog.getWindow();
        if(window == null){
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = gravity;
        window.setAttributes(windowAttributes);

        if(Gravity.BOTTOM == gravity) {
            dialog.setCancelable(true);
        }else{
            dialog.setCancelable(false);
        }

        AppCompatButton btnOk = dialog.findViewById(R.id.btnOk);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}