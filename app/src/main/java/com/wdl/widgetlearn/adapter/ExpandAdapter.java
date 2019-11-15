package com.wdl.widgetlearn.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.wdl.widgetlearn.R;
import com.wdl.widgetlearn.bean.ExpandableData;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by: wdl at 2019/11/7 9:47
 */
@SuppressWarnings("unused")
public class ExpandAdapter extends BaseExpandableListAdapter
{
    private List<ExpandableData> mDatas;

    public ExpandAdapter()
    {
        this.mDatas = new ArrayList<>();
    }

    public void setmDatas(List<ExpandableData> mDatas)
    {
        this.mDatas = mDatas;
        notifyDataSetChanged();
    }

    /**
     * 获取分组的count
     *
     * @return getGroupCount
     */
    @Override
    public int getGroupCount()
    {
        return (mDatas == null || mDatas.isEmpty()) ? 0 :
                mDatas.size();
    }

    /**
     * 获取每个分组下child的数量
     *
     * @param groupPosition groupPosition
     * @return getChildrenCount
     */
    @Override
    public int getChildrenCount(int groupPosition)
    {
        return (mDatas == null || mDatas.isEmpty()) ? 0 :
                mDatas.get(groupPosition).getChildDatas().size();
    }

    /**
     * 分组数据
     *
     * @param groupPosition groupPosition
     * @return Object
     */
    @Override
    public Object getGroup(int groupPosition)
    {
        return mDatas.get(groupPosition).getGroupTitle();
    }

    /**
     * 子选项数据
     *
     * @param groupPosition groupPosition
     * @param childPosition childPosition
     * @return Object
     */
    @Override
    public Object getChild(int groupPosition, int childPosition)
    {
        return mDatas.get(groupPosition).getChildDatas().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition)
    {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition)
    {
        return childPosition;
    }

    /**
     * 分组与子选项是否有稳定的ID
     *
     * @return true
     */
    @Override
    public boolean hasStableIds()
    {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent)
    {
        GroupViewHolder groupViewHolder;
        if (convertView == null)
        {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_group_layout, parent, false);
            groupViewHolder = new GroupViewHolder();
            groupViewHolder.tvTitle = convertView.findViewById(R.id.tv_title);
            convertView.setTag(groupViewHolder);
        } else
        {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }
        groupViewHolder.tvTitle.setText(mDatas.get(groupPosition).getGroupTitle());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent)
    {
        ChildViewHolder childViewHolder;
        if (convertView == null)
        {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_child_layout, parent, false);
            childViewHolder = new ChildViewHolder();
            childViewHolder.tvTitle = convertView.findViewById(R.id.tv_title);
            convertView.setTag(childViewHolder);
        } else
        {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }
        childViewHolder.tvTitle.setText(mDatas.get(groupPosition).getChildDatas().get(childPosition));
        return convertView;
    }

    /**
     * 子选项是否可点击
     *
     * @param groupPosition groupPosition
     * @param childPosition childPosition
     * @return boolean
     */
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition)
    {
        return true;
    }

    class GroupViewHolder
    {
        TextView tvTitle;
    }

    class ChildViewHolder
    {
        TextView tvTitle;
    }
}
