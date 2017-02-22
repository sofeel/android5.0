package com.zyt.android50.customwidgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by user on 2017/2/21.
 */

public class BullsEyeView extends View {

    private Paint mPaint;
    private Point mCenter;
    private int mRadius;

    //java构造器
    public BullsEyeView(Context context) {
        this(context, null);
    }

    //xml构造器
    public BullsEyeView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    //带有样式的xml构造器
    public BullsEyeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);
        mCenter = new Point();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width, height;
        //给定内容的理想大小
        int contentWidth = 100;
        int contentHeight = 100;

        width = getMeasurement(widthMeasureSpec, contentWidth);
        height = getMeasurement(heightMeasureSpec, contentHeight);
        setMeasuredDimension(width, height);
    }

    /**
     * 用于测量宽度和高度的辅助方法
     */
    private int getMeasurement(int measureSpac, int contentSize) {
        int specSize = MeasureSpec.getSize(measureSpac);
        switch (MeasureSpec.getMode(measureSpac)) {
            case MeasureSpec.AT_MOST://取最小值
                return Math.min(specSize, contentSize);
            case MeasureSpec.EXACTLY://取固定值
                return specSize;
            case MeasureSpec.UNSPECIFIED://未指定值，比如包裹
                return contentSize;
            default:
                return 0;

        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w != oldw || h != oldh) {
            //如果有变化，复位参数
            mCenter.x = w / 2;
            mCenter.y = h / 2;
            mRadius = Math.min(mCenter.x, mCenter.y);
        }
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制一系列从小到大颜色交替的同心圆
        mPaint.setColor(Color.RED);
        canvas.drawCircle(mCenter.x, mCenter.y, mRadius, mPaint);

        mPaint.setColor(Color.WHITE);
        canvas.drawCircle(mCenter.x, mCenter.y, mRadius * 0.8f, mPaint);

        mPaint.setColor(Color.BLUE);
        canvas.drawCircle(mCenter.x, mCenter.y, mRadius * 0.6f, mPaint);

        mPaint.setColor(Color.WHITE);
        canvas.drawCircle(mCenter.x, mCenter.y, mRadius * 0.4f, mPaint);

        mPaint.setColor(Color.RED);
        canvas.drawCircle(mCenter.x, mCenter.y, mRadius * 0.1f, mPaint);
    }
}
