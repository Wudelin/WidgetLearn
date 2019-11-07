package com.wdl.widgetlearn.remoteviews.provider;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.wdl.widgetlearn.R;
import com.wdl.widgetlearn.WidgetActivity;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MyAppWidgetProvider extends AppWidgetProvider
{
    private static RemoteViews remoteViews;
    public static final String ACTION = "com.wdl.android.action.CLICK";

    public MyAppWidgetProvider()
    {
        super();
    }

    /**
     * 每次桌面小部件更新时都调用
     *
     * @param context          Context
     * @param appWidgetManager AppWidgetManager
     * @param appWidgetIds     int
     */
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds)
    {

        super.onUpdate(context, appWidgetManager, appWidgetIds);
        for (int appWidgetId : appWidgetIds)
        {
            updateWidget(context, appWidgetManager, appWidgetId);
        }


    }

    static void updateWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId)
    {
        // 设置ACTION 获取广播

        Intent intent = new Intent();
        intent.setAction(ACTION);
        // intent.putExtra("id",appWidgetId);
        // Android 8.0 静态广播无法接收的解决方法一
        intent.setComponent(new ComponentName("com.wdl.widgetlearn",
                "com.wdl.widgetlearn.remoteviews.provider.MyAppWidgetProvider"));
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, intent, 0);
        //PendingIntent pi = PendingIntent.getActivity(context, 0, new Intent(context, WidgetActivity.class), 0);


//        Date day = new Date();
//        @SuppressLint("SimpleDateFormat")
//        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");

        // 实例化RemoteViews
        remoteViews = new RemoteViews(context.getPackageName(), R.layout.remoteviews_appwidget_layout);
        remoteViews.setTextViewText(R.id.textView, "" + new Date().getTime());
        remoteViews.setOnClickPendingIntent(R.id.textView1, pi);

        appWidgetManager.updateAppWidget(new ComponentName("com.wdl.widgetlearn",
                "com.wdl.widgetlearn.remoteviews.provider.MyAppWidgetProvider"), remoteViews);

    }

    /**
     * 第一次添加时调用
     *
     * @param context Context
     */
    @Override
    public void onEnabled(Context context)
    {
        super.onEnabled(context);
    }

    /**
     * 最后一个该类型的的桌面小部件被删除时调用
     *
     * @param context Context
     */
    @Override
    public void onDisabled(Context context)
    {
        super.onDisabled(context);
    }

    /**
     * 广播接收器
     *
     * @param context Context
     * @param intent  Intent
     */
    @Override
    public void onReceive(Context context, Intent intent)
    {
        super.onReceive(context, intent);
        Log.e("wdl", intent.getAction());
        AppWidgetManager manager = AppWidgetManager.getInstance(context);
        if (intent.getAction().equals(ACTION))
        {
            // 分发事件
            manager.updateAppWidget(new ComponentName("com.wdl.widgetlearn",
                    "com.wdl.widgetlearn.remoteviews.provider.MyAppWidgetProvider"),remoteViews);
        }

    }

    /**
     * 每删除一次调用一次
     *
     * @param context      Context
     * @param appWidgetIds int
     */
    @Override
    public void onDeleted(Context context, int[] appWidgetIds)
    {
        super.onDeleted(context, appWidgetIds);
    }
}
