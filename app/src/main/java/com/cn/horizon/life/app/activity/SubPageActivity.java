package com.cn.horizon.life.app.activity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.cn.horizon.life.R;
import com.cn.horizon.library.basic.BasicActivity;

import butterknife.Bind;

/**
 * Created by horizony on 2017/2/27.
 */

public class SubPageActivity extends BasicActivity {
    private String pictureURL = "http://nuuneoi.com/uploads/source/playstore/cover.jpg" ;

    @Bind(R.id.backdrop)
    ImageView backdrop;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_sub;
    }

    @Override
    protected void onViewCreated(Bundle saveInstanceState) {
        Glide.with(this).load(pictureURL).centerCrop().into(backdrop);
    }
}
