package com.wdl.widgetlearn.transformer;

import android.annotation.SuppressLint;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;

/**
 * Create by: wdl at 2019/12/17 15:20
 */
public class ScaleInTransformer implements ViewPager2.PageTransformer
{
    @SuppressLint("NewApi")
    @Override
    public void transformPage(@NonNull View page, float position)
    {
        page.setElevation(-Math.abs(position));
        final int pageWidth = page.getWidth();
        final int pageHeight = page.getHeight();
        page.setPivotX(pageWidth / 2);
        page.setPivotY(pageHeight / 2);

        // 不在屏幕内
        if (position < -1)
        {
            page.setScaleX(0.85f);
            page.setScaleY(0.85f);
            page.setPivotX(pageWidth);
        } else if (position <= 1)
        {
            if (position < 0)
            {
                final float scaleF = (1 + position) * (1 - 0.85f) + 0.85f;
                page.setScaleX(scaleF);
                page.setScaleY(scaleF);
                page.setPivotX(pageWidth + (0.5f + 0.5f * -position));
            } else
            {
                final float scaleF = (1 - position) * (1 - 0.85f) + 0.85f;
                page.setScaleX(scaleF);
                page.setScaleY(scaleF);
                page.setPivotX(pageWidth * ((1 - position) * 0.5f));
            }
        }else {
            page.setScaleX(0.85f);
            page.setScaleY(0.85f);
            page.setPivotX(0);
        }
    }
}
