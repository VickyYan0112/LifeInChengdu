package com.yan.LifeinChengdu.Main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.yan.LifeinChengdu.Food.FoodActivity;
import com.yan.LifeinChengdu.Weather.MyListActivity;
import com.yan.LifeinChengdu.Basic.BasicActivity;
import com.yan.LifeinChengdu.R;
import com.yan.LifeinChengdu.Travel.TravelActivity;

public class ClassificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classification);
    }

    public void onClick1(View view) {
        Intent intent = new Intent();
        intent.setClass(ClassificationActivity.this,BasicActivity.class);
        startActivity(intent);
    }

    public void onClick2(View view) {
        Intent intent = new Intent();
        intent.setClass(ClassificationActivity.this,TravelActivity.class);
        startActivity(intent);
    }


    public void onClick3(View view) {
        Intent intent = new Intent();
        intent.setClass(ClassificationActivity.this,MyListActivity.class);
        startActivity(intent);
    }

    public void onClick4(View view) {
        Intent intent = new Intent();
        intent.setClass(ClassificationActivity.this,FoodActivity.class);
        startActivity(intent);
    }

}
