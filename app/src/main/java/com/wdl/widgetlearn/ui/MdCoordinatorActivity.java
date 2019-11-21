package com.wdl.widgetlearn.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.wdl.widgetlearn.R;

/**
 * CoordinatorLayout
 * CoordinatorLayout is a super-powered FrameLayout
 * 使用场景：
 * 1.最外层布局
 * 2.协调子View的动作
 */
public class MdCoordinatorActivity extends AppCompatActivity
{
    private ImageView iv;

    public static void show(Context context)
    {
        context.startActivity(new Intent(context, MdCoordinatorActivity.class));
    }

    private static final String TAG = "MdCoordinatorActivity";

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_md_coordinator);
//        iv.setOnTouchListener(new View.OnTouchListener()
//        {
//            @Override
//            public boolean onTouch(final View v, final MotionEvent event)
//            {
//                Log.e(TAG, "onTouch: " + event.getAction());
//                switch (event.getAction())
//                {
//                    case MotionEvent.ACTION_DOWN:
//                        break;
//                    case MotionEvent.ACTION_MOVE:
//
//                        Log.e(TAG, "onTouch: " + (int) event.getX() + " " + (int) event.getY());
//                        v.scrollTo((int) event.getX(), (int) event.getY());
////                        v.post(new Runnable()
////                        {
////                            @Override
////                            public void run()
////                            {
////
////                            }
////                        });
//
//                        break;
//                    case MotionEvent.ACTION_UP:
//                        break;
//                    default:
//                        break;
//                }
//                return true;
//            }
//        });
    }
}
