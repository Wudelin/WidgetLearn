package com.wdl.widgetlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SimpleAdapter;
import android.widget.StackView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * StackView -- 容易造成oom
 * StackView是在一个栈中显示它的子控件，可以允许用户直接的去滑动它的子控件。
 *
 * 1.直接压缩图片
 * 2.将图片转为Bitmap再进行压缩
 */
public class StackViewActivity extends AppCompatActivity
{
    private int[] imgs = {R.drawable.webp_1, R.drawable.webp_2, R.drawable.webp_3};
    private StackView sv;

    public static void show(Context context)
    {
        context.startActivity(new Intent(context, StackViewActivity.class));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stackview);
        sv = findViewById(R.id.sv);
        initData();
    }

    /**
     * 初始化数据
     */
    private void initData()
    {
        List<Map<String, Integer>> mapList = new ArrayList<>();
        Map<String, Integer> mItemMap;
        for (int img : imgs)
        {
            mItemMap = new HashMap<>();
            mItemMap.put("img", img);
            mapList.add(mItemMap);
        }

        SimpleAdapter adapter = new SimpleAdapter(
                this,
                mapList,                        // 数据源
                R.layout.stack_item_layout,     // 子项布局的layout
                new String[]{"img"},            // 数据源中的key
                new int[]{R.id.iv_image}        // 子项中数据所需要设置的控件id
        );

        sv.setAdapter(adapter);
    }

    /**
     * 显示下一项
     *
     * @param view View
     */
    public void next(View view)
    {
        sv.showNext();
    }

    /**
     * 显示前一项
     *
     * @param view View
     */
    public void previous(View view)
    {
        sv.showPrevious();
    }
}
