package com.yan.reading.Main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.yan.reading.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void onClick1(View view){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,BookClassificationActivity.class);
        startActivity(intent);
    }
}
