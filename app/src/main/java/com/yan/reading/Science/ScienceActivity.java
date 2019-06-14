package com.yan.reading.Science;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yan.reading.PageAdapter.MyPageAdapter1;
import com.yan.reading.R;

public class ScienceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science);

        ViewPager viewPager1 = (ViewPager)findViewById(R.id.viewpager1);
        MyPageAdapter1 pageAdapter1 = new MyPageAdapter1(getSupportFragmentManager());
        viewPager1.setAdapter(pageAdapter1);

        TabLayout tabLayout1 = findViewById(R.id.sliding_tabs1);
        tabLayout1.setupWithViewPager(viewPager1);
    }
}
