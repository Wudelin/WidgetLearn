package com.wdl.widgetlearn.interview;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.lang.ref.WeakReference;

public class Test
{
    private static final int START = 0x01;
    private static final int END = 0x02;
    private static final Test ourInstance = new Test();

    public static Test getInstance()
    {
        return ourInstance;
    }

    private Test()
    {
    }

    public void increase(TextView textView)
    {
        M mHandler = new M(textView);
        mHandler.sendEmptyMessage(START);
    }

    private static class M extends Handler
    {
        private WeakReference<TextView> weakReference;
        private TextView mTv;

        public M(TextView tv)
        {
            super(Looper.getMainLooper());
            this.weakReference = new WeakReference<>(tv);
        }

        @Override
        public void handleMessage(@NonNull Message msg)
        {
            super.handleMessage(msg);
            switch (msg.what)
            {
                case START:
                    if (this.weakReference.get() != null)
                    {
                        this.mTv = this.weakReference.get();
                        if (Integer.valueOf(mTv.getText().toString()) != 100)
                        {
                            mTv.setText(String.valueOf(Integer.valueOf(mTv.getText().toString()) + 10));
                            sendEmptyMessageDelayed(START, 1000);
                        } else
                        {
                            sendEmptyMessage(END);
                        }
                    }
                    break;
                case END:
                    removeCallbacksAndMessages(this);
                    break;
                default:
            }
        }
    }
}
