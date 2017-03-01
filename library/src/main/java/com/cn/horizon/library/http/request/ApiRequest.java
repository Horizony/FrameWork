package com.cn.horizon.library.http.request;

import com.cn.horizon.library.http.manager.RetrofitManager;

import retrofit2.Retrofit;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by horizon on 2016/8/3:38
 */
public  class ApiRequest {
    private static ApiRequest instance;
    private Retrofit retrofit;
    private ApiService service;

    public static ApiRequest getInstance() {
        if (instance == null)
            instance = new ApiRequest();
        return instance;
    }

    private ApiRequest() {
        retrofit = RetrofitManager.getInstance().getRetrofit();
        service = retrofit.create(ApiService.class);
    }

    private <T> void toSubscribe(Observable<T> o, Subscriber<T> s) {
        o.subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).subscribe(s);
    }

//    public void userCheck(Subscriber<UserInfo> subscriber) {
//        Map<String, String> params = getBaseParam();
//        Observable observable = service.userCheck(params).map(new HttpResultFunc<UserInfo>());
//        toSubscribe(observable, subscriber);
//    }


}
