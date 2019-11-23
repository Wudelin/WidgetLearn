package com.wdl.widgetlearn.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;

import com.wdl.widgetlearn.R;

public class ViewStubActivity extends AppCompatActivity
{
    private ViewStub mVs;
    View mView;

    public static void show(Context context)
    {
        context.startActivity(new Intent(context, ViewStubActivity.class));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_stub);
        mVs = findViewById(R.id.vs);
    }

    public void expanded(View view)
    {
        try
        {
            if (mView == null) mView = mVs.inflate();

            ImageView iv = mView.findViewById(R.id.iv);
            iv.setBackgroundResource(R.drawable.w);
        } catch (Exception e)
        {
            mVs.setVisibility(View.VISIBLE);
        }

    }
}
