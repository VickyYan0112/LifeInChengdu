package com.yan.LifeinChengdu.PageAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.yan.LifeinChengdu.Fragment.FirstFragment;
import com.yan.LifeinChengdu.Fragment.SecondFragment;
import com.yan.LifeinChengdu.Fragment.ThirdFragment;

public class MyPageAdapter extends FragmentStatePagerAdapter {

    private String[] title;

    public MyPageAdapter(FragmentManager manager){
        super(manager);
        this.title= new String[]{"九天楼","IFS","青羊宫"};
    }
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new FirstFragment();
        } else if (position == 1) {
            return new SecondFragment();
        } else
            return new ThirdFragment();
    }

    public CharSequence getPageTitle(int position){

        return title[position];
    }

    @Override
    public int getCount() {
        return 3;
    }
}
