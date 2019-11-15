package com.wdl.widgetlearn.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Gallery;
import android.widget.ImageSwitcher;

import com.wdl.widgetlearn.R;
import com.wdl.widgetlearn.adapter.ImageAdapter;

public class GalleryActivity extends AppCompatActivity
{

    private Gallery mGallery;
    private int[] resIds = new int[]{
            R.drawable.webp_1,
            R.drawable.webp_2,
            R.drawable.webp_3
    };
    private ImageSwitcher is;

    public static void show(Context context)
    {
        context.startActivity(new Intent(context, GalleryActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        mGallery = findViewById(R.id.gallery);
        is = findViewById(R.id.is);

        ImageAdapter adapter = new ImageAdapter(is,this);
        adapter.setRes(resIds);
        mGallery.setAdapter(adapter);
        mGallery.setOnItemSelectedListener(adapter);
    }
}
