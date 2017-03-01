package com.cn.horizon.library.http.manager;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by horizon on 2016/7/19:59
 */
public class RetrofitManager {
    private static RetrofitManager retrofitManager;
    private Retrofit retrofit;

    private RetrofitManager() {

    }

    public void init(OkHttpClient mOkHttpClient, String baseUrl) {
        retrofit = new Retrofit
                .Builder().baseUrl(baseUrl).addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(mOkHttpClient).addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static RetrofitManager getInstance() {
        if (retrofitManager == null) {
            retrofitManager = new RetrofitManager();
            return retrofitManager;
        }
        return retrofitManager;
    }

    public Retrofit getRetrofit() {
        if (retrofit == null) {
            throw new RuntimeException("RetrofitManager no init");
        } else {
            return retrofit;
        }
    }
}
