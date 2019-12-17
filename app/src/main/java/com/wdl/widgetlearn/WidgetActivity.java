package com.wdl.widgetlearn;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Color;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ListView;
import android.widget.RemoteViews;
import android.widget.SimpleAdapter;

import com.wdl.widgetlearn.preference.PreActivity;
import com.wdl.widgetlearn.remoteviews.NotifyActivity;
import com.wdl.widgetlearn.ui.CommonlyActivity;
import com.wdl.widgetlearn.ui.DialogActivity;
import com.wdl.widgetlearn.ui.ExpandableListActivity;
import com.wdl.widgetlearn.ui.GalleryActivity;
import com.wdl.widgetlearn.ui.MDActivity;
import com.wdl.widgetlearn.ui.MdCoordinatorActivity;
import com.wdl.widgetlearn.ui.MdToolbarActivity;
import com.wdl.widgetlearn.ui.NotifyCationActivity;
import com.wdl.widgetlearn.ui.PopMenuActivity;
import com.wdl.widgetlearn.ui.ProgressBarActivity;
import com.wdl.widgetlearn.ui.StackViewActivity;
import com.wdl.widgetlearn.ui.ViewFlipperActivity;
import com.wdl.widgetlearn.ui.ViewStubActivity;
import com.wdl.widgetlearn.ui.Vp2Activity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WidgetActivity extends AppCompatActivity
{
    private static final String CHANNEL_ID = "channel_id";
    private static final String CHANNEL_NAME = "channel_name";

    private ListView listView;
    private String[] title = {
            "StackView",
            "FlipperView",
            "RemoteViews-notify",
            "RemoteViews-appwidget",
            "PreferenceFragment",
            "ExpandableList",
            "PopMenu",
            "ProgressBar",
            "CompoundButton",
            "Gallery",
            "Toolbar",
            "CoordinatorLayout",
            "MD",
            "ViewStub",
            "DialogFragment配合Dialog",
            "NotifyCation相关",
            "Viewpager2"
    };

    @SuppressLint("NewApi")
    @RequiresApi(api = Build.VERSION_CODES.N_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget);

        // API 25以上
        // 动态添加shortcut 动态删除 等 https://developer.android.google.cn/reference/android/content/pm/ShortcutManager.html
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.baidu.com"));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        ShortcutManager sm = (ShortcutManager) getSystemService(SHORTCUT_SERVICE);
        final ShortcutInfo in = new ShortcutInfo.Builder(this, "id1").setShortLabel("Short").setLongLabel("Long").setIcon(
                Icon.createWithResource(this, R.drawable.ic_arrow_back_black_24dp)
        ).setIntent(intent).build();
        assert sm != null;
        // 添加
        sm.addDynamicShortcuts(Collections.singletonList(in));

        // API 26及以上
        // 固定方式添加快捷
        // 1.判断是否支持固定快捷
        if (sm.isRequestPinShortcutSupported()){
            // 2.创建ShortcutInfo a:ID已存在直接查找创建 b:不存在创建新的
            final ShortcutInfo inw = new ShortcutInfo.Builder(this, "id1").build();
            final Intent pi = sm.createShortcutResultIntent(inw);
            // 3.通过广播判断创建是否完成
            PendingIntent p = PendingIntent.getBroadcast(this,0,pi,0);
            sm.requestPinShortcut(inw,p.getIntentSender());
        }


        listView = findViewById(R.id.lv);

        List<Map<String, String>> mapList = new ArrayList<>();
        Map<String, String> mItemMap;
        for (String title : title)
        {
            mItemMap = new HashMap<>();
            mItemMap.put("title", title);
            mapList.add(mItemMap);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,
                mapList,
                android.R.layout.simple_list_item_1,
                new String[]{"title"},
                new int[]{android.R.id.text1}
        );

        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
            {
                if (position == 0)
                {
                    StackViewActivity.show(WidgetActivity.this);
                } else if (position == 1)
                {
                    ViewFlipperActivity.show(WidgetActivity.this);
                } else if (position == 2)
                {
                    // NotifyCation
                    remoteViewsNotify();
                } else if (position == 3)
                {
                    ViewFlipperActivity.show(WidgetActivity.this);
                } else if (position == 4)
                {
                    PreActivity.show(WidgetActivity.this);
                } else if (position == 5)
                {
                    ExpandableListActivity.show(WidgetActivity.this);
                } else if (position == 6)
                {
                    PopMenuActivity.show(WidgetActivity.this);
                } else if (position == 7)
                {
                    ProgressBarActivity.show(WidgetActivity.this);
                } else if (position == 8)
                {
                    CommonlyActivity.show(WidgetActivity.this);
                } else if (position == 9)
                {
                    GalleryActivity.show(WidgetActivity.this);
                } else if (position == 10)
                {
                    MdToolbarActivity.show(WidgetActivity.this);
                } else if (position == 11)
                {
                    MdCoordinatorActivity.show(WidgetActivity.this);
                } else if (position == 12)
                {
                    MDActivity.show(WidgetActivity.this);
                } else if (position == 13)
                {
                    ViewStubActivity.show(WidgetActivity.this);
                } else if (position == 14)
                {
                    DialogActivity.show(WidgetActivity.this);
                } else if (position == 15)
                {
                    NotifyCationActivity.show(WidgetActivity.this);
                } else if (position == 16)
                {
                    Vp2Activity.show(WidgetActivity.this);
                }
            }
        });


    }

    /**
     * RemoteViews 进行通知
     * Step :
     * 1. 设置通知栏UI
     * 2. RemoteViews绑定布局
     * 3. PendingIntent
     * 4. 判断是否需要使用channel
     */
    private void remoteViewsNotify()
    {
        // 指定intent
        Intent intent = new Intent(this, NotifyActivity.class);
        intent.putExtra("extra", "remoteViewsNotify");
        // 相当于startActivity（intent）
        PendingIntent pi = PendingIntent.getActivity(this, 0x01, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        // 获取NotificationManager
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // 版本大于等于 26 通知需要使用channel
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            NotificationChannel nc = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            nc.setDescription("description");
            nc.setLightColor(Color.BLUE);
            nc.enableLights(true);
            nc.enableVibration(true);
            // 偶数表示静止时间，奇数表示振动时间
            nc.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            assert manager != null;
            manager.createNotificationChannel(nc);
        }

        // 通过传入包名，自定义通知栏的layout实例化RemoteViews
        // RemoteViews 使用有限制：
        /*
         * 布局:   LinearLayout，RelativeLayout，FrameLayout，GridLayout
         * 控件:   AnalogClock，Button，Chronometer，ImageButton，ImageView，ProgressBar，TextView，ViewFlipper，ListView，GridView，StackView，                 AdapterViewFlipper
         *        注：只支持这些View，不包括其子类，以及自定义的View。
         */
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.remoteviews_notify_layout);
        remoteViews.setTextViewText(R.id.textView, "新消息");
        remoteViews.setImageViewResource(R.id.imageView, R.drawable.webp_2);
        remoteViews.setOnClickPendingIntent(R.id.notify, pi);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setAutoCancel(false)
                .setContentTitle("title")
                .setContentText("test")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setOngoing(true)                  // 左、右滑是否删除
                .setCustomContentView(remoteViews)
                .setWhen(System.currentTimeMillis())
                .build();
        assert manager != null;
        manager.notify(0x01, notification);
    }
}
