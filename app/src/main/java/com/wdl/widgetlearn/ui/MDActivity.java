package com.wdl.widgetlearn.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.appbar.AppBarLayout;
import com.gyf.immersionbar.ImmersionBar;
import com.wdl.widgetlearn.R;

/**
 * 参考 : https://material.io/develop/android/
 * <p>
 * 1.CoordinatorLayout->AppBarLayout
 * 2.CoordinatorLayout->AppBarLayout->CollapsingToolbarLayout-> {ImageView Toolbar}
 * <p>
 * CoordinatorLayout：通过指定具体Behavior控制其他View的动作等，Super-powered FrameLayout
 * <p>
 * <p>
 * CollapsingToolbarLayout 就相当于ChildView
 * AppBarLayout: 通过指定layout_scrollFlags控制是否滑动等
 * 属性值：
 * 1.scroll
 * Child View 伴随着滚动事件而滚出或滚进屏幕。注意两点：
 * 第一点，如果使用了其他值，必定要使用这个值才能起作用；
 * 第二点：如果在这个child View前面的任何其他Child View没有设置这个值，那么这个Child View的设置将失去作用。
 * 2.enterAlways 必须配合scroll
 * 快速返回模式
 * 当向下滚动时，先滚动child View；当child View全部进入屏幕时，在滚动ScrollView的内容
 * <p>
 * 3.enterAlwaysCollapsed 必须配合scroll
 * enterAlways的附加值。
 * 这里涉及到Child View的高度和最小高度;
 * 向下滚动时，Child View先向下滚动最小高度值，然后ScrollView开始滚动，到达边界时，Child View再向下滚动，直至显示完全。
 * <p>
 * 4.exitUntilCollapsed 必须配合scroll
 * 发生向上滚动事件时，Child View向上滚动退出直至最小高度，然后Scrolling View开始滚动。也就是，Child View不会完全退出屏幕。
 * <p>
 * 5.snap | snapMargin 必须配合scroll
 * 要么进要么出
 *
 * <p>
 * CollapsingToolbarLayout ： 通过指定layout_collapseMode 。 layout_collapseParallaxMultiplier控制视觉差 是否固定等
 * 属性值：
 * 1.parallax 滚动
 * 2.pin 固定
 *
 * AppBarLayout 监听
 */
public class MDActivity extends AppCompatActivity
{
    private AppBarLayout mBar;
    public static void show(Context context)
    {
        context.startActivity(new Intent(context, MDActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_md);
        //StatusBarUtil.setTranslucent(this);
        ImmersionBar.with(this).transparentStatusBar();
        mBar = findViewById(R.id.appbar);

        // 滚动状态监听
        mBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener()
        {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset)
            {
                // 获取 总的滑动距离
                appBarLayout.getTotalScrollRange();

                // verticalOffset 已经滑动距离



            }
        });
    }
}
