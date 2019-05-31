package com.byd.myapplication.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.settingslib.core.lifecycle.ObservablePreferenceFragment;
import com.byd.myapplication.R;

public class DemoFragment extends ObservablePreferenceFragment {
    private static final String TAG = "DemoFragment";

    public DemoFragment() {
        Log.d(TAG, "Demo Fragment succeed");
    }

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        addPreferencesFromResource(R.xml.demo_prefs);
        Log.d(TAG, "addPreferencesFromResource succeed");

    }

    @Override
    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override
    public void onCreatePreferences(Bundle bundle, String value) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
