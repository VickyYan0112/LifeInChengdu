package com.yan.reading.News;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yan.reading.PageAdapter.MyPageAdapter2;
import com.yan.reading.R;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        ViewPager viewPager2 = (ViewPager)findViewById(R.id.viewpager2);
        MyPageAdapter2 pageAdapter2 = new MyPageAdapter2(getSupportFragmentManager());
        viewPager2.setAdapter(pageAdapter2);

        TabLayout tabLayout2 = findViewById(R.id.sliding_tabs2);
        tabLayout2.setupWithViewPager(viewPager2);
    }
}
