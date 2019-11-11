package com.wdl.widgetlearn.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

import com.wdl.widgetlearn.R;


/**
 * 常用控件
 * Button/ImageButton/Switch/ToggleButton/RadioButton等
 */
public class CommonlyActivity extends AppCompatActivity
{

    private Switch mSwitch;
    private SwitchCompat mSwitchCompat;
    private AppCompatToggleButton mTb;
    private RadioGroup mRg;
    private RadioButton mRb1, mRb2;
    private CheckBox mCb;

    public static void show(Context context)
    {
        context.startActivity(new Intent(context, CommonlyActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commonly);
        mSwitch = findViewById(R.id.sw);
        mSwitchCompat = findViewById(R.id.sc);
        mTb = findViewById(R.id.tb);
        mRg = findViewById(R.id.rg);
        mRb1 = findViewById(R.id.rb1);
        mRb2 = findViewById(R.id.rb2);
        mCb = findViewById(R.id.cb);
        mCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                mCb.setChecked(isChecked);
            }
        });
        mRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                group.check(checkedId);
            }
        });

        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                mSwitch.setChecked(isChecked);
            }
        });

        mSwitchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                mSwitchCompat.setChecked(isChecked);
            }
        });

        mTb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                mTb.setChecked(isChecked);
            }
        });
    }
}
