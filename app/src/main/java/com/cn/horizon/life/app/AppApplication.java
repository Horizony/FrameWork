package com.cn.horizon.life.app;

import com.cn.horizon.library.basic.BasicApplication;

/**
 * Created by horizony on 2017/3/2.
 */

public class AppApplication extends BasicApplication {
    public static boolean isDebug = true;


    @Override
    protected boolean isDebug() {
        return isDebug;
    }
}
