package com.yan.reading.Main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.yan.reading.News.NewsActivity;
import com.yan.reading.R;
import com.yan.reading.Science.ScienceActivity;
import com.yan.reading.Sports.WeatherListActivity;

public class BookClassificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_classification);
    }

    public void onClick2(View view) {
        Intent intent = new Intent();
        intent.setClass(BookClassificationActivity.this,ScienceActivity.class);
        startActivity(intent);
    }

    public void onClick3(View view) {
        Intent intent = new Intent();
        intent.setClass(BookClassificationActivity.this,NewsActivity.class);
        startActivity(intent);
    }

    public void onClick4(View view) {
        Intent intent = new Intent();
        intent.setClass(BookClassificationActivity.this,WeatherListActivity.class);
        startActivity(intent);
    }

}
