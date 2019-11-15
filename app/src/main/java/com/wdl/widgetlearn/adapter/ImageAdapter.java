package com.wdl.widgetlearn.adapter;

import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.wdl.widgetlearn.R;

/**
 * Create by: wdl at 2019/11/15 11:39
 */
public class ImageAdapter extends BaseAdapter
{
    private int[] res;

    public void setRes(int[] res)
    {
        this.res = res;
        notifyDataSetChanged();
    }

    @Override
    public int getCount()
    {
        return res.length;
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
        ImageView iv = new ImageView(parent.getContext());
        iv.setImageResource(res[position]);
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return iv;
    }
}
