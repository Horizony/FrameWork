package com.cn.horizon.life.http.helper;

import android.content.Context;

import com.cn.horizon.life.utils.Logger;

import rx.Subscriber;

/**
 * Created by horizon on 2016/8/4:56
 */
public class RequestSubscriber<T> extends Subscriber<T> implements RequestDialogHandler.RequestCancelListener {
    private ResponseListener mResponseListener;
    private RequestDialogHandler mProgressDialogHandler;
    private Context mContext;

    /**
     * 显示dialog
     *
     * @param context
     * @param cancelable       dialog是否可以取消
     * @param responseListener
     */
    public RequestSubscriber(Context context, boolean cancelable, ResponseListener responseListener) {
        this.mContext = context;
        this.mResponseListener = responseListener;
        mProgressDialogHandler = new RequestDialogHandler(context, cancelable, this);
    }

    /**
     * 不显示dialog
     *
     * @param context
     * @param responseListener
     */
    public RequestSubscriber(Context context, ResponseListener responseListener) {
        this.mContext = context;
        this.mResponseListener = responseListener;
    }


    private void showProgressDialog() {
        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.obtainMessage(RequestDialogHandler.SHOW_PROGRESS_DIALOG).sendToTarget();
        }
    }

    private void dismissProgressDialog() {
        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.obtainMessage(RequestDialogHandler.DISMISS_PROGRESS_DIALOG).sendToTarget();
            mProgressDialogHandler = null;
        }
    }

    @Override
    public void onStart() {
        showProgressDialog();
    }

    @Override
    public void onCompleted() {
        dismissProgressDialog();
        mResponseListener.onComplete();
    }

    @Override
    public void onError(Throwable e) {
        dismissProgressDialog();
        mResponseListener.onComplete();
        Logger.d(e.getMessage());
        if (e != null && e instanceof RequestException) {
            mResponseListener.onError(e.getMessage());
        } else {
            mResponseListener.onError("网络异常，请重试！");
            e.printStackTrace();
        }

    }

    @Override
    public void onNext(T t) {
        mResponseListener.onSuccess(t);
        mResponseListener.onComplete();
    }

    @Override
    public void onCancelProgress() {
        if (!this.isUnsubscribed()) {
            this.unsubscribe();
        }
        mResponseListener.onComplete();
    }
}
