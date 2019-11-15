package com.wdl.widgetlearn.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;

import com.wdl.widgetlearn.R;
import com.wdl.widgetlearn.ui.GalleryActivity;

/**
 * Create by: wdl at 2019/11/15 11:39
 */
public class ImageAdapter extends BaseAdapter implements AdapterView.OnItemSelectedListener, ViewSwitcher.ViewFactory
{
    private int[] res;
    private ImageSwitcher is;
    private Context context;
    private static final String TAG = "ImageAdapter";

    public ImageAdapter(ImageSwitcher is, Context context)
    {
        this.is = is;
        this.context = context;
        is.setFactory(this);
        // 设置ImageSwitcher组件显示图像的动画效果
        is.setInAnimation(AnimationUtils.loadAnimation(context, android.R.anim.fade_in));
        is.setOutAnimation(AnimationUtils.loadAnimation(context, android.R.anim.fade_out));
    }

    public void setRes(int[] res)
    {
        this.res = res;
        notifyDataSetChanged();
    }

    @Override
    public int getCount()
    {
        return Integer.MAX_VALUE;
    }

    @Override
    public Object getItem(int position)
    {
        return res[position];
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ImageView iv = new ImageView(context);
        // 无限循环
        iv.setImageResource(res[position % res.length]);
        Gallery.LayoutParams params = new Gallery.LayoutParams(100, 100);
        iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
        iv.setLayoutParams(params);
        return iv;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        // gallery选中时将资源ID赋予给ImageSwitcher
        is.setImageResource(res[position % res.length]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }

    /**
     * 创建一个View放置于ImageSwitcher
     *
     * @return View
     */
    @Override
    public View makeView()
    {
        ImageView imageView = new ImageView(context);
        imageView.setBackgroundColor(0xFF000000);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setLayoutParams(new ImageSwitcher.
                LayoutParams(200, 200));
        return imageView;
    }
}
