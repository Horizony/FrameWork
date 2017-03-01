package com.cn.horizon.life.ndk;

/**
 * Created by horizony on 2017/3/1.
 */

public class NDkTest {
    public native static String hello();

    static {
        System.loadLibrary("ndk_test.lib");
    }
}
