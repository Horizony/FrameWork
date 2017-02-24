package com.cn.horizon.life.http.helper;


import com.cn.horizon.life.http.bean.HttpResult;

import rx.functions.Func1;

/**
 * Created by horizon on 2016/8/3:08
 */
public class RequestResultFunc<R> implements Func1<HttpResult<R>, R> {

    @Override
    public R call(HttpResult<R> httpResult) {
        if (httpResult.getErrorCode() != 200) {
            throw new RequestException(httpResult.getErrorCode() + " : " + httpResult.getReason());
        }
        return httpResult.getResult();
    }
}
