package com.cn.horizon.library.http.helper;

/**
 * Created by horizon on 2016/8/4:00
 */
public interface ResponseListener<T> {
    void onComplete();

    void onError(String msg);

    void onSuccess(T t);
}
