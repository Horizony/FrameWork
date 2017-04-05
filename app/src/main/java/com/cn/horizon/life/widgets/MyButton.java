package com.cn.horizon.life.widgets;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

import com.cn.horizon.library.utils.Logger;

/**
 * Created by horizony on 2017/3/21.
 */

public class MyButton extends Button {
    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d("View TouchEvent", MyButton.class.getSimpleName() + " dispatchTouchEvent");

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("View TouchEvent", MyButton.class.getSimpleName() + "dispatchTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("View TouchEvent", MyButton.class.getSimpleName() + "dispatchTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("View TouchEvent", MyButton.class.getSimpleName() + "dispatchTouchEvent ACTION_UP");
                break;
        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("View TouchEvent", MyButton.class.getSimpleName() + " onTouchEvent");
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("View TouchEvent", MyButton.class.getSimpleName() + "onTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("View TouchEvent", MyButton.class.getSimpleName() + "onTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("View TouchEvent", MyButton.class.getSimpleName() + "onTouchEvent ACTION_UP");
                break;
        }
        return super.onTouchEvent(event);
    }
}
