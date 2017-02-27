package com.cn.horizon.life.basic;

import android.os.Bundle;

/**
 * Created by horizony on 2017/2/27.
 */

public abstract class LazyFragment extends BasicFragment {
    private boolean isFirstResume = true;
    private boolean isFirstVisible = true;
    private boolean isPrepared;

    @Override
    public void onResume() {
        super.onResume();
        if (getUserVisibleHint()) {
            onResumeLazy();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (getUserVisibleHint()) {
            onPauseLazy();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            if (isFirstVisible) {
                isFirstVisible = false;
                onFirstVisible();
            } else {
                onResumeLazy();
            }
        } else {
            onPauseLazy();
        }
    }

    /**
     * Fragment首次可见
     */
    protected abstract void onFirstVisible();

    /**
     * Fragment可见（类似于onResume）
     */
    protected abstract void onResumeLazy();

    /**
     * Fragment不可见（类似于onPause）
     */
    protected abstract void onPauseLazy();

}
