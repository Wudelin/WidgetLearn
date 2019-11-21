package com.wdl.widgetlearn.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/**
 * Create by: wdl at 2019/11/21 10:41
 */
public class DependencyView extends View
{
    private final Paint mPaint;
    private int w;
    private int h;
    private int lastX;
    private int lastY;

    public DependencyView(Context context)
    {
        this(context, null);
    }

    public DependencyView(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setColor(Color.parseColor("#000000"));
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        super.onSizeChanged(w, h, oldw, oldh);
        this.w = w;
        this.h = h;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        int ox = (int) event.getRawX();
        int oy = (int) event.getRawY();
        switch (event.getAction())
        {
            case MotionEvent.ACTION_MOVE:
                CoordinatorLayout.MarginLayoutParams layoutParams = (CoordinatorLayout.MarginLayoutParams) getLayoutParams();
                final int left = layoutParams.leftMargin + ox - lastX;
                final int top = layoutParams.topMargin + oy - lastY;
                layoutParams.leftMargin = left;
                layoutParams.topMargin = top;
                setLayoutParams(layoutParams);
                requestLayout();

                break;
            default:
                break;
        }
        lastX = ox;
        lastY = oy;
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        canvas.drawRect(0, 0, w, h, mPaint);
    }
}
