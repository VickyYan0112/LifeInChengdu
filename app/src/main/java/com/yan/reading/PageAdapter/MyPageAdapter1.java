package com.yan.reading.PageAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.yan.reading.Fragment.FirstFragment;
import com.yan.reading.Fragment.SecondFragment;

public class MyPageAdapter1 extends FragmentStatePagerAdapter {

    private String[] title1;

    public MyPageAdapter1(FragmentManager manager1){
        super(manager1);
        this.title1= new String[]{"谣言粉碎机","奇葩视觉赏"};
    }
    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new FirstFragment();
        }else{
            return new SecondFragment();
        }
    }

    public CharSequence getPageTitle(int position){

        return title1[position];
    }

    @Override
    public int getCount() {
        return 2;
    }
}
