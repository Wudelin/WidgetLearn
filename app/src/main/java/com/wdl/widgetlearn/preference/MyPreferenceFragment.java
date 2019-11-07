package com.wdl.widgetlearn.preference;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import com.wdl.widgetlearn.R;

public class MyPreferenceFragment extends PreferenceFragmentCompat
{
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey)
    {
        setPreferencesFromResource(R.xml.setting_layout, rootKey);
    }
}
