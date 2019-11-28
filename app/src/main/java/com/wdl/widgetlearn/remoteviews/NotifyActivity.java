package com.wdl.widgetlearn.remoteviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.wdl.widgetlearn.R;

public class NotifyActivity extends AppCompatActivity
{
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify);
        mTv = findViewById(R.id.tv);
        Intent intent = getIntent();
        String extra = intent.getStringExtra("extra");
        mTv.setText(extra);

    }
}
