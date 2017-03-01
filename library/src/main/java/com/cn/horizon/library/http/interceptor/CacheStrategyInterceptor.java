package com.cn.horizon.library.http.interceptor;



import com.cn.horizon.library.basic.BasicApplication;
import com.cn.horizon.library.utils.NetWorkUtils;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class CacheStrategyInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (!NetWorkUtils.isConnected(BasicApplication.appContext)) {
            request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
        }
        Response originalResponse = chain.proceed(request);
        if (NetWorkUtils.isConnected(BasicApplication.appContext)) {
            String cacheControl = request.cacheControl().toString();
            return originalResponse.newBuilder().header("Cache-Control", cacheControl)
                    .removeHeader("Pragma").build();
        } else {
            return originalResponse.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + Integer.MAX_VALUE)
                    .removeHeader("Pragma").build();
        }
    }
}
