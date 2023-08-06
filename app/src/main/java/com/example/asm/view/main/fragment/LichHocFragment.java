package com.example.asm.view.main.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asm.R;

import com.example.asm.view.main.Adapter.CourceAdapter;
import com.example.asm.view.main.Adapter.DateAdapter;
import com.example.asm.view.main.dto.SchedulesResponeDTO;
import com.example.asm.view.main.helpers.IRetrofitInterface;
import com.example.asm.view.main.helpers.RetrofitHelper;
import com.example.asm.view.main.model.DateModel;
import com.example.asm.view.main.model.Schedules;
import com.example.asm.view.main.recycleview.IRecycleview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LichHocFragment extends Fragment implements IRecycleview {
    ArrayList<DateModel> listDate;
    List<Schedules> listSchedule;
    RecyclerView recyclerViewDate, recyclerViewCource;
    // import interface retrofit
    IRetrofitInterface iRetrofitInterface;
    CourceAdapter adapter2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lich_hoc, container, false);
        recyclerViewDate = view.findViewById(R.id.recyclerViewDate);
        recyclerViewCource = view.findViewById(R.id.recyclerViewCource);
        listSchedule = new ArrayList<>();

        iRetrofitInterface = RetrofitHelper.createService(IRetrofitInterface.class);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        int type = 1;
        String user_id = "ps24524";
        String date = "2023-08-01";
        Map<String, String> queries = new HashMap<>();
        queries.put("user_id" , user_id+"");
        queries.put("type" , type+"");
        queries.put("date" , date);

        iRetrofitInterface.getSchedules(queries).enqueue(schedulesCallBack);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initDataDate();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL, false);
        recyclerViewDate.setLayoutManager(layoutManager);
        DateAdapter adapter = new DateAdapter(listDate, getContext(), this);
        recyclerViewDate.setAdapter(adapter);

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getContext());
        recyclerViewCource.setLayoutManager(layoutManager2);
        adapter2 = new CourceAdapter(listSchedule, getContext(), this);
        recyclerViewCource.setAdapter(adapter2);
    }

    Callback<SchedulesResponeDTO> schedulesCallBack = new Callback<SchedulesResponeDTO>() {
        @Override
        public void onResponse(Call<SchedulesResponeDTO> call, Response<SchedulesResponeDTO> response) {
            if (response.isSuccessful()){
                SchedulesResponeDTO getSchedulesResponeDTO = response.body();
                listSchedule.clear();
                listSchedule.addAll(getSchedulesResponeDTO.getData());
                adapter2.notifyDataSetChanged();
            }
        }
        @Override
        public void onFailure(Call<SchedulesResponeDTO> call, Throwable t) {
            Log.d(">>> SchedulesResponeDTO", "onFailure: " + t.getMessage());
        }
    };
    @Override
    public void onItemClickSchedule(int position) {
        Toast.makeText(getContext(), "Click item schedule", Toast.LENGTH_LONG);
        getAllCource(Gravity.CENTER, position);
    }

    @Override
    public void onItemClickDate(int position) {
        Toast.makeText(getContext(), "Click item date", Toast.LENGTH_LONG);
        int type = 1;
        String user_id = "ps24513";
        String date = listDate.get(position).getNgayThangNam();
        Map<String, String> queries = new HashMap<>();
        queries.put("type" , type+"");
        queries.put("user_id" , user_id+"");
        queries.put("date" , date);
        iRetrofitInterface.getSchedules(queries).enqueue(schedulesCallBack);
        Intent intent = new Intent(getActivity(), DateAdapter.class);
        intent.putExtra("position", position);


    }

    private void getAllCource(int gravity, int position){
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
        TextView txtNgay = dialog.findViewById(R.id.txtNgay);
        TextView txtPhong = dialog.findViewById(R.id.txtPhong);
        TextView txtGiangDuong = dialog.findViewById(R.id.txtGiangDuong);
        TextView txtLop = dialog.findViewById(R.id.txtLop);
        TextView txtThoiGian = dialog.findViewById(R.id.txtThoiGian);
        TextView txtMon = dialog.findViewById(R.id.txtMon);
        TextView txtMaMon = dialog.findViewById(R.id.txtMaMon);
        TextView txtGiangVien = dialog.findViewById(R.id.txtGiangVien);

        txtNgay.setText("Ngày: "+listSchedule.get(position).getDay());
        txtPhong.setText("Phòng: "+listSchedule.get(position).getRoom());
        txtGiangDuong.setText("Giảng đường: "+listSchedule.get(position).getAddress());
        txtLop.setText("Lớp: "+listSchedule.get(position).getClass_name());
        txtThoiGian.setText("Thời gian: "+listSchedule.get(position).getTime());
        txtMon.setText("Môn: "+listSchedule.get(position).getCourse_name());
        txtMaMon.setText("Mã môn: "+listSchedule.get(position).getCourse_id());
        txtGiangVien.setText("Giảng viên:"+listSchedule.get(position).getTeacher_name());

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private void initDataDate(){
        // danh sach Date
        listDate = new ArrayList<>();
        listDate.add(new DateModel(1, 1, "TUE","2023-08-01"));
        listDate.add(new DateModel(2, 2, "WED", "2023-08-02"));
        listDate.add(new DateModel(3, 3, "THU", "2023-08-03"));
        listDate.add(new DateModel(4, 4, "FRI", "2023-08-04"));
        listDate.add(new DateModel(5, 5, "SAT", "2023-08-05"));
        listDate.add(new DateModel(6, 6, "SUN", "2023-08-06"));
        listDate.add(new DateModel(7, 7, "MON", "2023-08-07"));
        listDate.add(new DateModel(8, 8, "TUE", "2023-08-08"));
        listDate.add(new DateModel(9, 9, "WED", "2023-08-09"));
        listDate.add(new DateModel(10, 10, "THU", "2023-08-10"));
        listDate.add(new DateModel(11, 11, "FRI", "2023-08-11"));
        listDate.add(new DateModel(12, 12, "SAT", "2023-08-12"));
        listDate.add(new DateModel(13, 13, "SUN", "2023-08-13"));
        listDate.add(new DateModel(14, 14, "MON", "2023-08-14"));
        listDate.add(new DateModel(15, 15, "TUE", "2023-08-15"));
        listDate.add(new DateModel(16, 16, "WED", "2023-08-16"));
        listDate.add(new DateModel(17, 17, "THU", "2023-08-17"));


        //danh sach mon hoc


    }
}