package com.example.asm.view.main.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.asm.R;
import com.example.asm.view.main.model.Cource;

import java.util.List;

public class StackAdapter extends ArrayAdapter {
    private List<Cource> listCource;
    private Context context;

    public StackAdapter(@NonNull Context context, int resource, List<Cource> listCource) {
        super(context, resource);
        this.listCource = listCource;
        this.context = context;
    }

    @Override
    public int getCount() {
        // on below line returning the size of number list.
        return listCource.size();
    }
    // on below line creating a get view method to inflate the layout file.
    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        // on below line checking if the view is empty or not.
        if (view == null) {
            // if the view is empty we are inflating the layout file on below line.
            // on below line specifying the layout file name which we have already created.
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemcource_stack, parent, false);
        }
        // on below line creating and initializing the variable for our image view.
        final TextView txtGio, txtThoiGianKetThuc, txtMon,txtPhong, txtGiangVien;
        txtGio = view.findViewById(R.id.txtGio);
        txtMon = view.findViewById(R.id.txtMon);
        txtPhong = view.findViewById(R.id.txtPhong);
        txtGiangVien = view.findViewById(R.id.txtGiangVien);
        // on below line setting image view from our array list.
        txtGio.setText(listCource.get(position).getThoiGianBatDau()+ " - "+ listCource.get(position).getThoiGianKetThuc());
        txtMon.setText(listCource.get(position).getMon()+" - "+ listCource.get(position).getMaMon());
        txtPhong.setText(listCource.get(position).getPhong()+"");
        txtGiangVien.setText(listCource.get(position).getGiangVien()+"");

        // on below line returning the view.
        return view;
    }


}
