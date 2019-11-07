package com.wdl.widgetlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class ViewFlipperActivity extends AppCompatActivity
{

    private int[] imgs = {R.drawable.webp_1, R.drawable.webp_2, R.drawable.webp_3};
    private ViewFlipper viewFlipper;

    private float startX;
    private static final float MIN_SCR = 200f;

    public static void show(Context context)
    {
        context.startActivity(new Intent(context, ViewFlipperActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_flipper);
        viewFlipper = findViewById(R.id.vf);
        initView();
    }

    /**
     * 初始化view
     */
    private void initView()
    {
        for (int img : imgs)
        {
            viewFlipper.addView(getImageView(img));
        }
    }

    /**
     * 获取ImageView
     *
     * @param resId 资源ID
     * @return ImageView
     */
    private ImageView getImageView(int resId)
    {
        ImageView iv = new ImageView(this);
        iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
        iv.setBackgroundResource(resId);
        return iv;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                startX = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                // 向右滑动-> 左进左出
                if (event.getX() - startX >= MIN_SCR)
                {
                    viewFlipper.setInAnimation(this, R.anim.left_in);
                    viewFlipper.setOutAnimation(this, R.anim.left_out);
                    viewFlipper.showPrevious();
                } else
                {
                    // 向左滑动-> 右进右出
                    viewFlipper.setInAnimation(this, R.anim.right_in);
                    viewFlipper.setOutAnimation(this, R.anim.right_out);
                    viewFlipper.showNext();
                }
                break;
            case MotionEvent.ACTION_MOVE:
                break;
        }
        return super.onTouchEvent(event);
    }

    /**
     * 开启、关闭轮播
     *
     * @param view View
     */
    public void start(View view)
    {
        if (viewFlipper.isFlipping())
            viewFlipper.stopFlipping();
        else
            viewFlipper.startFlipping();
    }
}
