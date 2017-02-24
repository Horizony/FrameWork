package com.cn.horizon.life.app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.multidex.MultiDexApplication;

import com.cn.horizon.life.http.interceptor.CacheStrategyInterceptor;
import com.cn.horizon.life.http.manager.OkHttpManager;
import com.cn.horizon.life.http.manager.RetrofitManager;
import com.cn.horizon.life.utils.Logger;

import okhttp3.OkHttpClient;

/**
 * Created by Administrator on 2016/10/25.
 */

public class AppApplication extends MultiDexApplication {
    public static final String BASE_URL = "https://www.baidu.com/";
    public static final boolean DEBUG = true;
    public static Context appContext;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;

        //初始化网络请求
        OkHttpClient httpClient = OkHttpManager.getInstance(this).
                addInterceptor(new CacheStrategyInterceptor()).build();
        RetrofitManager.getInstance().init(httpClient, BASE_URL);

        initRegisterActivity();
    }

    private void initRegisterActivity() {
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                Logger.d(activity.getClass().getSimpleName() + " is created");
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {
                Logger.d(activity.getClass().getSimpleName() + " is stopped");
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                Logger.d(activity.getClass().getSimpleName() + " is destroyed");
            }

        });
    }
}
