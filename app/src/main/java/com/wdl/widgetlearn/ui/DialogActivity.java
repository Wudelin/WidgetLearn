package com.wdl.widgetlearn.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.wdl.widgetlearn.R;
import com.wdl.widgetlearn.ui.fragment.FireMissilesDialogFragment;

import java.util.List;

public class DialogActivity extends AppCompatActivity implements FireMissilesDialogFragment.NoticeCallback
{

    private FireMissilesDialogFragment mDialog;

    public static void show(Context context)
    {
        context.startActivity(new Intent(context, DialogActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }

    public void show(View view)
    {
        if (mDialog == null)
        {
            mDialog = new FireMissilesDialogFragment();
        }
        mDialog.show(getSupportFragmentManager(), "miss");
    }

    @Override
    public void cancel(DialogFragment dialog)
    {

    }

    @Override
    public void submit(DialogFragment dialog, List<String> resultArr)
    {
        if (resultArr != null && !resultArr.isEmpty())
            Toast.makeText(this, resultArr.toString(), Toast.LENGTH_SHORT).show();
    }


}
