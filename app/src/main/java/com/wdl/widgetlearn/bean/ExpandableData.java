package com.wdl.widgetlearn.bean;

import java.util.List;

/**
 * Create by: wdl at 2019/11/7 9:54
 */
public class ExpandableData
{
    private String groupTitle;
    private List<String> childDatas;

    public ExpandableData()
    {
    }

    public ExpandableData(String groupTitle, List<String> childDatas)
    {
        this.groupTitle = groupTitle;
        this.childDatas = childDatas;
    }

    public String getGroupTitle()
    {
        return groupTitle;
    }

    public void setGroupTitle(String groupTitle)
    {
        this.groupTitle = groupTitle;
    }

    public List<String> getChildDatas()
    {
        return childDatas;
    }

    public void setChildDatas(List<String> childDatas)
    {
        this.childDatas = childDatas;
    }
}
