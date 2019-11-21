package com.wdl.widgetlearn.behavior;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.wdl.widgetlearn.ui.DependencyView;

/**
 * Create by: wdl at 2019/11/21 10:13
 * 自定义Behavior
 * 泛型T 即为被动响应的view
 */
@SuppressWarnings("unused")
public class CorBehavior extends CoordinatorLayout.Behavior<Button>
{
    private final int mWidth;

    public CorBehavior(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        mWidth = context.getResources().getDisplayMetrics().widthPixels;
    }

    /**
     * @param parent     CoordinatorLayout
     * @param child      需要随之变化的View
     * @param dependency 依赖的view
     * @return
     */
    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull Button child, @NonNull View dependency)
    {
        return dependency instanceof DependencyView;
    }

    /**
     * 跟随逻辑
     *
     * @param parent     CoordinatorLayout
     * @param child      child
     * @param dependency dependency
     * @return true
     */
    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull Button child, @NonNull View dependency)
    {
        // top left
        final int top = dependency.getTop();
        final int left = dependency.getLeft();

        final int x = mWidth - left - child.getWidth();
        final int y = top;

        change(child, x, y);

        return true;
    }

    /**
     *
     * @param child Button
     * @param x leftMargin
     * @param y topMargin
     */
    private void change(Button child, int x, int y)
    {
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) child.getLayoutParams();
        params.leftMargin = x;
        params.topMargin = y;
        child.setLayoutParams(params);

    }
}
