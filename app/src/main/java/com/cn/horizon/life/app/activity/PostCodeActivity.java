package com.cn.horizon.life.app.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.cn.horizon.life.R;
import com.cn.horizon.life.basic.BasicActivity;

import butterknife.Bind;

/**
 * Created by horizony on 2016/11/21.
 */

public class PostCodeActivity extends BasicActivity{
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_post_code;
    }

    @Override
    protected void onViewCreated(Bundle saveInstanceState) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
