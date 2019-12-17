package com.wdl.widgetlearn.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wdl.widgetlearn.R;
import com.wdl.widgetlearn.remoteviews.NotifyActivity;

/**
 * 通知
 * 1. 获取NotificationManagerCompat
 * 2. 判断api判断是否要创建NotificationChannel
 * 3. NotificationManagerCompat.createNotificationChannel(channel)
 * 4. 创建NotificationCompat
 * 5. NotificationManagerCompat.notify(id,notifyCation)
 */
public class NotifyCationActivity extends AppCompatActivity
{

    private Button mBtn2;
    public static void show(Context context)
    {
        context.startActivity(new Intent(context, NotifyCationActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify_cation);
        mBtn2 = findViewById(R.id.button2);
    }

    public void sendNotify(View view)
    {
        createNotificationChannel();

        // 添加点击事件-跳转等
        Intent intent = new Intent(this, NotifyActivity.class);
        intent.putExtra("extra", "contentIntent");
        PendingIntent pi = PendingIntent.getActivity(this, 0x01, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        // 添加按钮并添加intent
        Intent intent2 = new Intent(this, NotifyActivity.class);
        intent2.putExtra("extra", "action");
        PendingIntent action = PendingIntent.getActivity(this, 0x02, intent2, PendingIntent.FLAG_UPDATE_CURRENT);

        // 发送
        getManager().notify(0x02, getNotifyCation(pi, action).build());
    }

    /**
     * 获取 NotificationManager
     *
     * @return NotificationManager
     */
    private NotificationManagerCompat getManager()
    {
        return NotificationManagerCompat.from(this);
    }

    /**
     * 判断api 是否添加NotificationChannel
     */
    private void createNotificationChannel()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            String name = getPackageName();
            NotificationChannel channel = new NotificationChannel(
                    name,
                    name,
                    NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("Description");
            getManager().createNotificationChannel(channel);
        }
    }

    /**
     * 获取Notification
     *
     * @return Notification
     */
    private NotificationCompat.Builder getNotifyCation(PendingIntent pi, PendingIntent action)
    {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, getPackageName())
                .setSmallIcon(R.drawable.ic_ac_unit_black_24dp)
                .setContentText("Much longer text that cannot fit one line... Much longer text that cannot fit one line...")
                .setContentTitle("My NotifyCation")
                // 添加点击意图
                .setContentIntent(pi)
                // 添加按钮 action
                .addAction(R.drawable.ic_arrow_back_black_24dp, "Action", action)
                .setAutoCancel(true)
                .setProgress(100, 10, false)
                .setStyle(new NotificationCompat.BigTextStyle().bigText("Much longer text that cannot fit one line... " +
                        "Much longer text that cannot fit one line..."));
        return builder;
    }
}
