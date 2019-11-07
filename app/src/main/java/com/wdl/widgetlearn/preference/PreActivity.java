package com.wdl.widgetlearn.preference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.wdl.widgetlearn.R;
import com.wdl.widgetlearn.StackViewActivity;

public class PreActivity extends AppCompatActivity
{

    public static void show(Context context)
    {
        context.startActivity(new Intent(context, PreActivity.class));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre);
        getSupportFragmentManager().beginTransaction().replace(R.id.lay_container,new MyPreferenceFragment()).commit();
    }
}
