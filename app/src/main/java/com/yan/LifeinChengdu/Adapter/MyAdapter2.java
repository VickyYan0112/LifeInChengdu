package com.yan.LifeinChengdu.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.yan.LifeinChengdu.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyAdapter2 extends ArrayAdapter {
    private static final String TAG = "MyAdapter2";

    public MyAdapter2(Context context, int resource, ArrayList<HashMap<String,String>> list) {
        super(context, resource,list);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View itemView = convertView;
        if(itemView ==null){
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_hot_pot,parent,false);
        }

        Map<String,String> map = (Map<String, String>) getItem(position);
        TextView title = (TextView) itemView.findViewById(R.id.itemTitle);
        TextView detail = (TextView) itemView.findViewById(R.id.itemDetail);

        title.setText("商家"+ map.get("ItemTitle1"));
        detail.setText("电话和位置"+map.get("ItemDetail1"));

        return itemView;
    }
}


