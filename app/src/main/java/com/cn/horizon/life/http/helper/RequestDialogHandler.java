package com.cn.horizon.life.http.helper;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;

/**
 * Created by horizon on 2016/8/4:53
 */
public class RequestDialogHandler extends Handler {
    public interface RequestCancelListener {
        void onCancelProgress();
    }
    public static final int SHOW_PROGRESS_DIALOG = 1;
    public static final int DISMISS_PROGRESS_DIALOG = 2;

    private ProgressDialog dialog;

    private Context context;
    private boolean cancelable = false;
    private RequestCancelListener mCancelListener;

    public RequestDialogHandler(Context context, boolean cancelable, RequestCancelListener mCancelListener) {
        super();
        this.context = context;
        this.cancelable = cancelable;
        this.mCancelListener = mCancelListener;
    }

    private void initProgressDialog() {
        if (dialog == null) {
            dialog = new ProgressDialog(context);
            dialog.setCancelable(cancelable);
            if (cancelable) {
                dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        mCancelListener.onCancelProgress();
                    }
                });
            }

            if (!dialog.isShowing()) {
                dialog.show();
            }
        }
    }

    private void dismissProgressDialog() {
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }
    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case SHOW_PROGRESS_DIALOG:
                initProgressDialog();
                break;
            case DISMISS_PROGRESS_DIALOG:
                dismissProgressDialog();
                break;
        }
    }
}
