package com.cn.horizon.life.widgets;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.PathShape;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.cn.horizon.library.utils.Logger;

/**
 * Created by horizony on 2017/3/24.
 */

public class MyRingView extends View {
    private final int DEFAULT_SIZE = 240;
    private int squareWidth = DEFAULT_SIZE;
    private final int STROKE_WIDTH = 80;
    private int centerX, centerY;
    private Paint usePaint, unUsePaint;
    private RectF outOval, inOval;
    private RectF startOval, endOval;
    private float startAngle = -90;
    private float sweepAngle = 270;
    private int endRadio = STROKE_WIDTH / 2;
    private float topEndX, topEndY;

    private Path path = new Path();

    public MyRingView(Context context) {
        super(context);
        init();
    }

    public MyRingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyRingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyRingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        usePaint = new Paint();
        usePaint.setColor(Color.RED);
        usePaint.setAntiAlias(true);
        usePaint.setStrokeWidth(2);
        usePaint.setStyle(Paint.Style.FILL);

        unUsePaint = new Paint();
        unUsePaint.setColor(Color.GRAY);
        unUsePaint.setAntiAlias(true);
        unUsePaint.setStrokeWidth(STROKE_WIDTH);
        unUsePaint.setStyle(Paint.Style.STROKE);

        outOval = new RectF();
        inOval = new RectF();
        startOval = new RectF();
        endOval = new RectF();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(DEFAULT_SIZE, DEFAULT_SIZE);
        } else if (widthMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(DEFAULT_SIZE, heightSize);
        } else if (heightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSize, DEFAULT_SIZE);
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        squareWidth = Math.min(getWidth() - getPaddingLeft() - getPaddingRight(), getHeight() - getPaddingTop() - getPaddingBottom());
        centerX = getWidth() / 2;
        centerY = getHeight() / 2;
        outOval.set(centerX - squareWidth / 2, centerY - squareWidth / 2, centerX + squareWidth / 2, centerY + squareWidth / 2);
        inOval.set(outOval.left + STROKE_WIDTH, outOval.top + STROKE_WIDTH, outOval.right - STROKE_WIDTH, outOval.bottom - STROKE_WIDTH);
        int starrCenterX = centerX;
        int startCenterY = centerY - (squareWidth / 2 - STROKE_WIDTH / 2);
        startOval.set(starrCenterX - STROKE_WIDTH / 2, startCenterY - STROKE_WIDTH / 2, starrCenterX + STROKE_WIDTH / 2, startCenterY + STROKE_WIDTH / 2);

        int endCenterX = centerX - (squareWidth / 2 - STROKE_WIDTH / 2);
        int endCenterY = centerY;
        endOval.set(endCenterX - STROKE_WIDTH / 2, endCenterY - STROKE_WIDTH / 2, endCenterX + STROKE_WIDTH / 2, endCenterY + STROKE_WIDTH / 2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        path.moveTo(centerX, centerY - squareWidth / 2);
        Path p1 = new Path();
        p1.addArc(outOval, startAngle, sweepAngle);
        Path p2 = new Path();
        p2.addArc(startOval, 90, 180);
        Path p3 = new Path();
        p3.addArc(endOval, 180, 180);
        Path p4 = new Path();
        p4.addArc(inOval, startAngle, sweepAngle);
        p1.op(p2, Path.Op.UNION);
        p1.op(p3, Path.Op.UNION);
        p1.op(p4, Path.Op.UNION);


//        path.lineTo(centerX - squareWidth / 2, centerY);
//        path.lineTo(centerX, centerY + squareWidth / 2);
//        path.lineTo(centerX + squareWidth / 2, centerY);
//        path.lineTo(centerX , centerY);
//        path.lineTo(centerX, centerY - squareWidth / 2);
        path.close();
        RectF r = new RectF();
        //计算控制点的边界
        path.computeBounds(r, true);
        //设置区域路径和剪辑描述的区域
        Region region = new Region();
        region.setPath(path, new Region((int) r.left, (int) r.top, (int) r.right, (int) r.bottom));
        canvas.drawPath(path, usePaint);
    }
}
