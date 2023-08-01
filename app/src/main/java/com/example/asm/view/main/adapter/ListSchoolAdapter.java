package com.example.asm.view.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.asm.R;

import java.util.List;

public class ListSchoolAdapter extends ArrayAdapter<String> {
    private Context context;
    private List<String> list;


    public ListSchoolAdapter(@NonNull Context context, List<String> list) {
        super(context, R.layout.list_item_school, list);
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View _view, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.list_item_school, parent, false);

        TextView itemlist = view.findViewById(R.id.itemList);
        itemlist.setText(list.get(position));
        return view;
    }
}
