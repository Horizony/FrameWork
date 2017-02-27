package com.cn.horizon.life.app.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;

import com.cn.horizon.life.R;
import com.cn.horizon.life.app.adapter.MainPagerAdapter;
import com.cn.horizon.life.app.fragment.MainPageFragment;
import com.cn.horizon.life.basic.BasicActivity;

import butterknife.Bind;
import butterknife.OnClick;

public class MainPageActivity extends BasicActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tabs)
    TabLayout tabs;
    @Bind(R.id.viewpager)
    ViewPager viewpager;
    @Bind(R.id.fab)
    FloatingActionButton fab;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onViewCreated(Bundle saveInstanceState) {
        setSupportActionBar(toolbar);
        initViewPager(viewpager);
        tabs.setupWithViewPager(viewpager);
    }

    private void initViewPager(ViewPager viewPager) {
        if (viewPager == null) return;
        MainPagerAdapter adapter = new MainPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new MainPageFragment(), "Category 1");
        adapter.addFragment(new MainPageFragment(), "Category 2");
        adapter.addFragment(new MainPageFragment(), "Category 3");
        viewPager.setAdapter(adapter);
    }

    @OnClick({R.id.fab})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab:
//                Snackbar.make(view, "Here's a SnackBar", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
                startActivity(SubPageActivity.class);
                break;
        }
    }
}
