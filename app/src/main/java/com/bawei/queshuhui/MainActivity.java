package com.bawei.queshuhui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.bawei.queshuhui.base.BaseActivity;
import com.bawei.queshuhui.util.NetUtil;
import com.bawei.queshuhui.view.fragment.HomeFragment;
import com.bawei.queshuhui.view.fragment.MyFragment;
import com.bawei.queshuhui.view.fragment.ShopCarFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private ViewPager viewPager;
    private RadioGroup radioGroup;
    private HomeFragment homeFragment;
    private ShopCarFragment shopCarFragment;
    private MyFragment myFragment;
    List<Fragment>list = new ArrayList<>();

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        viewPager = findViewById(R.id.vp);
        radioGroup = findViewById(R.id.rg);

        homeFragment = new HomeFragment();
        shopCarFragment = new ShopCarFragment();
        myFragment = new MyFragment();

        list.add(homeFragment);
        list.add(shopCarFragment);
        list.add(myFragment);

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.btn1:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.btn2:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.btn3:
                        viewPager.setCurrentItem(2);
                        break;
                }
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                radioGroup.check(radioGroup.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        radioGroup.check(radioGroup.getChildAt(0).getId());
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }
}
