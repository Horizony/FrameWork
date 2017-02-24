package com.cn.horizon.life.app.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.cn.horizon.life.R;
import com.cn.horizon.life.basic.BasicActivity;

import butterknife.Bind;
import butterknife.OnClick;

public class MainPageActivity extends BasicActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.ivFun1)
    ImageView ivFun1;
    @Bind(R.id.ivFun2)
    ImageView ivFun2;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onViewCreated(Bundle saveInstanceState) {
        setSupportActionBar(toolbar);
    }

    @OnClick({R.id.ivFun1, R.id.ivFun2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivFun1:
                startActivity(PostCodeActivity.class);
                break;
            case R.id.ivFun2:
                startActivity(RecycleViewActivity.class);
                break;
        }
    }

}
