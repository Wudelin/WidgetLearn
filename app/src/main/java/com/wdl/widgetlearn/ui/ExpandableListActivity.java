package com.wdl.widgetlearn.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ExpandableListView;

import com.wdl.widgetlearn.R;
import com.wdl.widgetlearn.adapter.ExpandAdapter;
import com.wdl.widgetlearn.bean.ExpandableData;

import java.util.ArrayList;
import java.util.List;

/**
 * 可展开ListView
 */
public class ExpandableListActivity extends AppCompatActivity
{
    private ExpandableListView expandableListView;
    private ExpandAdapter mAdapter;

    public static void show(Context context)
    {
        context.startActivity(new Intent(context, ExpandableListActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list);
        expandableListView = findViewById(R.id.elv);
        mAdapter = new ExpandAdapter();
        expandableListView.setAdapter(mAdapter);
        List<ExpandableData> mList = new ArrayList<>();
        ExpandableData data;
        for (int i = 0; i < 5; i++)
        {
            String groupTitle = "groupTitle " + i;
            List<String> childTitle = new ArrayList<>();
            for (int j = 0; j < 6; j++)
            {
                childTitle.add("childTitle " + j);
            }
            data = new ExpandableData(groupTitle, childTitle);
            mList.add(data);
        }
        mAdapter.setmDatas(mList);

    }
}
