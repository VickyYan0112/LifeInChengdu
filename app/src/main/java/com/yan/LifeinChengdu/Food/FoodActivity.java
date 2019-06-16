package com.yan.LifeinChengdu.Food;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.yan.LifeinChengdu.Main.ClassificationActivity;
import com.yan.LifeinChengdu.Main.MainActivity;
import com.yan.LifeinChengdu.R;

public class FoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
    }

    public void onClick8(View view){
        Intent intent = new Intent();
        intent.setClass(FoodActivity.this,HotPotActivity.class);
        startActivity(intent);
    }


}
