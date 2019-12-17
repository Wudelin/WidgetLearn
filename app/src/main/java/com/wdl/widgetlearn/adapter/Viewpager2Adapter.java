package com.wdl.widgetlearn.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wdl.widgetlearn.R;

import java.util.Arrays;
import java.util.List;

/**
 * Create by: wdl at 2019/12/17 14:53
 * Viewpager2 适配器
 */
@SuppressWarnings("unused")
public class Viewpager2Adapter extends RecyclerView.Adapter<Viewpager2Adapter.Vp2ViewHolder>
{
    private List<String> mList = Arrays.asList("#CCFF99", "#41F1E5", "#8D41F1", "#FF99CC");

    @NonNull
    @Override
    public Vp2ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new Vp2ViewHolder(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.vp2_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Vp2ViewHolder holder, int position)
    {
        holder.bind(position);
    }

    @Override
    public int getItemCount()
    {
        return mList != null ? mList.size() : 0;
    }

    class Vp2ViewHolder extends RecyclerView.ViewHolder
    {

        private TextView mTv;

        Vp2ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            mTv = itemView.findViewById(R.id.tv_text);
        }

        void bind(final int position)
        {
            mTv.setText(String.valueOf(position));
            mTv.setBackgroundColor(Color.parseColor(mList.get(position)));
        }
    }
}
