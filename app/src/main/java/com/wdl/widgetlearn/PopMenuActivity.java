package com.wdl.widgetlearn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.widget.PopupMenu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.Field;

public class PopMenuActivity extends AppCompatActivity
{
    private static final String TAG = "PopMenuActivity";

    private Button button;

    public static void show(Context context)
    {
        context.startActivity(new Intent(context, PopMenuActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_menu);
        button = findViewById(R.id.button);
        button.setOnLongClickListener(new View.OnLongClickListener()
        {
            @Override
            public boolean onLongClick(View v)
            {
                showPopMenu();
                return false;
            }
        });
    }

    /**
     * 显示PopMenu
     */
    private void showPopMenu()
    {
        /*
         * 上下文、目标View(即锚点)
         */
        PopupMenu popupMenu = new PopupMenu(this, button,Gravity.TOP);
        popupMenu.getMenuInflater().inflate(R.menu.pop_munu_layout, popupMenu.getMenu());
        setIconShow(popupMenu);
        //popupMenu.show();
        /**
         * item 点击监听
         */
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener()
        {
            @Override
            public boolean onMenuItemClick(MenuItem item)
            {
                Toast.makeText(PopMenuActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        /**
         * 控件消失的监听
         */
        popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener()
        {
            @Override
            public void onDismiss(PopupMenu menu)
            {

            }
        });

        /**
         * 根据ID查找到item
         */
        Log.e(TAG, "" + popupMenu.getMenu().findItem(R.id.add_queue).getTitle().toString());


    }

    /**
     * 设置icon显示
     *
     * @param popupMenu PopupMenu
     */
    private void setIconShow(PopupMenu popupMenu)
    {
        try
        {
            Field field = popupMenu.getClass().getDeclaredField("mPopup");
            field.setAccessible(true);
            MenuPopupHelper helper = (MenuPopupHelper) field.get(popupMenu);
            assert helper != null;
            helper.setForceShowIcon(true);
            // 手动控制偏移的位置并显示
            helper.show(100,100);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
