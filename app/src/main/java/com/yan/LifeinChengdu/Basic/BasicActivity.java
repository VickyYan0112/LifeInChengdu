package com.yan.LifeinChengdu.Basic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.yan.LifeinChengdu.Food.FoodActivity;
import com.yan.LifeinChengdu.R;
import com.yan.LifeinChengdu.Travel.TravelActivity;
import com.yan.LifeinChengdu.Weather.MyListActivity;

public class BasicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);

    }


    public void onClick2(View view) {
        Intent intent = new Intent();
        intent.setClass(BasicActivity.this,TravelActivity.class);
        startActivity(intent);
    }


    public void onClick3(View view) {
        Intent intent = new Intent();
        intent.setClass(BasicActivity.this,MyListActivity.class);
        startActivity(intent);
    }

    public void onClick4(View view) {
        Intent intent = new Intent();
        intent.setClass(BasicActivity.this,FoodActivity.class);
        startActivity(intent);
    }
}
