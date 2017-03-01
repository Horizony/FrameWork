package com.cn.horizon.life.app.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.cn.horizon.life.R;
import com.cn.horizon.library.basic.LazyFragment;
import com.cn.horizon.life.ndk.NDkTest;
import com.cn.horizon.library.utils.Logger;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by horizony on 2017/2/27.
 */

public class MainPageFragment extends LazyFragment {
    @Bind(R.id.container)
    LinearLayout container;

    @Bind(R.id.test)
    View test;

    @Override
    protected void onFirstVisible() {

    }

    @Override
    protected void onResumeLazy() {

    }

    @Override
    protected void onPauseLazy() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_layout;
    }

    @OnClick({R.id.container, R.id.test})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.container:
                Logger.e(NDkTest.hello());
                break;
            case R.id.test:
                break;
        }

    }

    @Override
    public void onViewCreatedFinish(Bundle savedInstanceState) {

    }
}
