package com.wdl.widgetlearn.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.wdl.widgetlearn.R;
import com.wdl.widgetlearn.adapter.Viewpager2Adapter;
import com.wdl.widgetlearn.transformer.ScaleInTransformer;

/**
 * Viewpager2 使用
 * https://juejin.im/post/5df4aabe6fb9a0161104c8eb 相关文章
 */
public class Vp2Activity extends AppCompatActivity
{
    private ViewPager2 mVp2;

    /**
     * 显示
     *
     * @param context Context
     */
    public static void show(final Context context)
    {
        context.startActivity(new Intent(context, Vp2Activity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vp2);
        mVp2 = findViewById(R.id.vp2);
        mVp2.setAdapter(new Viewpager2Adapter());

        // Viewpager2 默认滚动方向为横向
        // setOrientation 动态设置滚动方向
        mVp2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        // 页面滑动监听
        mVp2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback()
        {
            @Override
            public void onPageSelected(int position)
            {
                super.onPageSelected(position);
                Toast.makeText(Vp2Activity.this, "position:" + position, Toast.LENGTH_SHORT).show();
            }
        });

        // Viewpager2 声明为final类 无法通过以前的方式禁止用户滑动
        // 新的API禁止用户输入 false为禁止
        mVp2.setUserInputEnabled(true);

        // 设置一屏多页
        mVp2.setOffscreenPageLimit(1);
        RecyclerView mRv = (RecyclerView) mVp2.getChildAt(0);
        final int padding = getResources().getDimensionPixelOffset(R.dimen.dp_10);
        mRv.setPadding(padding,0,padding,0);
        mRv.setClipToPadding(false);


        // Transformer 可设置动画、间距等
        // 设置页面间距
        // mVp2.setPageTransformer(new MarginPageTransformer(30));
        // CompositePageTransformer 设置组合 动画等
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(10));
        compositePageTransformer.addTransformer(new ScaleInTransformer());
        mVp2.setPageTransformer(compositePageTransformer);

    }

    public void fakeDragBy(View view)
    {
        // fakeDragBy动态模拟拖拽 正数（往前、上） 负数（相反）
        // beginFakeDrag 开启模拟拖拽
        mVp2.beginFakeDrag();
        if (mVp2.fakeDragBy(-300))
        {
            mVp2.endFakeDrag();
        }
    }
}
