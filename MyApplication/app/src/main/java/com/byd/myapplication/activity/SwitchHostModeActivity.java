package com.byd.myapplication.activity;

//import android.os.SystemProperties;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.byd.myapplication.R;
import com.byd.myapplication.fragment.DemoFragment;

public class SwitchHostModeActivity extends AppCompatActivity {
    private static final String TAG ="SwitchHostModeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DemoFragment trustedCredentialsSettings = new DemoFragment();
        getFragmentManager().beginTransaction().replace(R.id.demo_fragment, trustedCredentialsSettings).commit();
        //SystemProperties.set("sys.usb.typec.mode", "dfp");
        Log.i(TAG, "set host mode");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        //SystemProperties.set("sys.usb.typec.mode", "ufp");
        Log.i(TAG, "set device mode");
    }
}
