package com.wdl.widgetlearn.interview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.wdl.widgetlearn.R;

public class InterviewActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Test.getInstance().increase((TextView) findViewById(R.id.textView2));
    }
}
