package com.cn.horizon.life.http.manager;


import android.content.Context;
import android.util.Log;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public final class OkHttpManager {
    private static final String TAG = OkHttpManager.class.getSimpleName();
    private static final int CONNECT_TIMEOUT_MILLIS = 5 * 1000;//连接时间超时
    private static final int WRITE_TIMEOUT_MILLIS = 10 * 1000;//写入时间超时
    private static final int READ_TIMEOUT_MILLIS = 10 * 1000;//读取时间超时
    private static final int CACHE_SIZE = 100 * 1024 * 1024;//缓存大小
    private static OkHttpManager instance;
    private static List<Interceptor> mInterceptors;
    private static Context appContext;

    public OkHttpManager() {
        mInterceptors = new LinkedList<>();
    }

    /**
     * 单例实例
     *
     * @return OkHttpHelper实例
     */
    public static OkHttpManager getInstance(Context appContext) {
        OkHttpManager.appContext = appContext;
        if (instance == null)
            instance = new OkHttpManager();
        return instance;
    }

    /**
     * 构建OkHttpClient
     *
     * @return OkHttpClient
     */
    public OkHttpClient build() {
        return generateOkHttpClient(mInterceptors);
    }

    /**
     * 添加拦截器
     *
     * @param interceptor 拦截器
     * @return OkHttpHelper
     */
    public OkHttpManager addInterceptor(Interceptor interceptor) {
        mInterceptors.add(interceptor);
        return this;
    }

    /**
     * 获得OkHttp客户端
     *
     * @return OkHttp客户端
     */
    public OkHttpClient generateOkHttpClient(List<Interceptor> interceptors) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(CONNECT_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
                .writeTimeout(WRITE_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
                .readTimeout(READ_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
        if (interceptors != null && interceptors.size() > 0) {
            for (Interceptor interceptor : interceptors) {
                builder.addInterceptor(interceptor);
            }
        }
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i(TAG, message);
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(loggingInterceptor);
        String mCacheDirPath = appContext.getExternalCacheDir().getPath();
        Cache cache = new Cache(new File(mCacheDirPath, "httpCache"), CACHE_SIZE);
        builder.cache(cache);
        return builder.build();
    }
}
