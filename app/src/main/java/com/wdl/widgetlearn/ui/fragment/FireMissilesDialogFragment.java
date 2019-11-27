package com.wdl.widgetlearn.ui.fragment;

import android.app.Dialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;


import com.wdl.widgetlearn.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Create by: wdl at 2019/11/27 16:35
 * DialogFragment 配合 Dialog
 * <p>
 * https://developer.android.google.cn/guide/topics/ui/dialogs#top_of_page 参考链接
 */
@SuppressWarnings("unused")
public class FireMissilesDialogFragment extends DialogFragment
{
    public interface NoticeCallback
    {
        void cancel(DialogFragment dialog);

        void submit(DialogFragment dialog, List<String> resultArr);
    }

    private NoticeCallback mCallback;

    @Override
    public void onAttach(@NonNull Context context)
    {
        super.onAttach(context);
        try
        {
            mCallback = (NoticeCallback) context;
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState)
    {
//---------------------------------------------------------- 最简单的    AlertDialog ----------------------------------------------------
//        AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(getActivity()), R.style.dialog);
//        builder
//                .setTitle("FireMissiles")
//                .setCancelable(false)
//                .setMessage("Content")
//                .setPositiveButton("Position", new DialogInterface.OnClickListener()
//                {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which)
//                    {
//
//                    }
//                })
//                .setNegativeButton("Negative", new DialogInterface.OnClickListener()
//                {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which)
//                    {
//
//                    }
//                });
//
//        return builder.create();

//------------------------------------------------- 添加列表 无法显示message和列表 还可以通过setAdapter设置自定列表--------------------------------------------------
//        final String items[] = new String[]{"item1", "item2", "item3"};
//        AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
//        builder
//                .setTitle("FireMissiles")
//                .setCancelable(false)
//                .setItems(items, new DialogInterface.OnClickListener()
//                {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which)
//                    {
//                        Toast.makeText(getActivity(), items[which], Toast.LENGTH_SHORT).show();
//                    }
//                });

// -------------------------------------- setSingleChoiceItems 设置单选列表--------------------------------
//        final String items[] = new String[]{"item1", "item2", "item3"};
//        AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
//        builder
//                .setTitle("FireMissiles")
//                .setCancelable(false)
//                .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener()
//                {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which)
//                    {
//                        Toast.makeText(getActivity(), items[which], Toast.LENGTH_SHORT).show();
//                    }
//                });


        // 多选 + 回调
        final String items[] = new String[]{"item1", "item2", "item3"};
        final List<String> selectedArr = new ArrayList<>();
        AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
        builder
                .setTitle("FireMissiles")
                .setCancelable(true)
                .setMultiChoiceItems(items, null, new DialogInterface.OnMultiChoiceClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked)
                    {
                        if (isChecked)
                            selectedArr.add(items[which]);
                        else
                            selectedArr.remove(items[which]);
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        if (mCallback != null) mCallback.cancel(FireMissilesDialogFragment.this);
                    }
                })
                .setPositiveButton("确认", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {

                        if (mCallback != null)
                            mCallback.submit(FireMissilesDialogFragment.this, selectedArr);
                    }
                });

        // 可通过 setView 设置自定义布局
//        LayoutInflater inflater = requireActivity().getLayoutInflater();
//        AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
//        builder
//                .setCancelable(true)
//                .setView(inflater.inflate(R.layout.vs_layout, null))
//                .setNegativeButton("取消", new DialogInterface.OnClickListener()
//                {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which)
//                    {
//                        dialog.cancel();
//                    }
//                })
//                .setPositiveButton("确认", new DialogInterface.OnClickListener()
//                {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which)
//                    {
//                    }
//                });

        return builder.create();
    }

}
