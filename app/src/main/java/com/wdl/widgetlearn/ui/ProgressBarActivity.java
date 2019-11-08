package com.wdl.widgetlearn.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;

import com.wdl.widgetlearn.R;

/***
 * https://www.jianshu.com/p/8f3db94d7efe
 * ProgressBar
 */

public class ProgressBarActivity extends AppCompatActivity
{
    private ProgressBar pb1, pb2;

    public static void show(Context context)
    {
        context.startActivity(new Intent(context, ProgressBarActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        pb1 = findViewById(R.id.pb);
        pb2 = findViewById(R.id.pb1);
        mHandler.sendEmptyMessage(0x01);
    }

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler()
    {
        @Override
        public void handleMessage(@NonNull Message msg)
        {
            super.handleMessage(msg);
            if (msg.what == 0x01)
            {
                if (pb2.getProgress() != 100)
                {
                    pb2.setProgress(pb2.getProgress() + 10);
                    sendEmptyMessageDelayed(0x01,1000);
                } else
                {
                    sendEmptyMessage(0x02);
                }
            }else if (msg.what == 0x02){
            }
        }
    };
}
