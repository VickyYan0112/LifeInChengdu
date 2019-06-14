package com.yan.reading.PageAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.yan.reading.Fragment.FifthFragment;
import com.yan.reading.Fragment.FourthFragment;
import com.yan.reading.Fragment.SixthFragment;

public class MyPageAdapter3 extends FragmentStatePagerAdapter {
    private String[] title3;

    public MyPageAdapter3(FragmentManager manager3){
        super(manager3);
        this.title3= new String[]{"篮球新闻","足球新闻"};
    }
    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new FifthFragment();
        }else{
            return new SixthFragment();
        }
    }

    public CharSequence getPageTitle(int position){

        return title3[position];
    }

    @Override
    public int getCount() {
        return 2;
    }
}
