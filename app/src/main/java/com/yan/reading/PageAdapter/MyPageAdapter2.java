package com.yan.reading.PageAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.yan.reading.Fragment.FifthFragment;
import com.yan.reading.Fragment.FourthFragment;
import com.yan.reading.Fragment.ThirdFragment;

public class MyPageAdapter2 extends FragmentStatePagerAdapter {

    private String[] title2;

    public MyPageAdapter2(FragmentManager manager2){
        super(manager2);
        this.title2= new String[]{"国内八卦","国外八卦"};
    }
    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new ThirdFragment();
        }else{
            return new FourthFragment();
        }
    }

    public CharSequence getPageTitle(int position){

        return title2[position];
    }

    @Override
    public int getCount() {
        return 2;
    }
}
