package com.wdl.widgetlearn.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.wdl.widgetlearn.R;

/**
 * Md toolbar appbarlayout等使用
 */
public class MdToolbarActivity extends AppCompatActivity
{

    public static void show(Context context)
    {
        context.startActivity(new Intent(context, MdToolbarActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_md_toolbar);
        Toolbar mToolbar = findViewById(R.id.mToolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });
    }
}
