package com.byd.myapplication.intentservices;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.byd.myapplication.R;

public class StartIntentServiceActivity extends Activity {

    @Override
    public void onCreate(Bundle savedStates) {
        super.onCreate(savedStates);
        setContentView(R.layout.activity_start_intent_service);
    }

    public void startIntentService(View view) {
        Intent startIntentService = new Intent(this, RSSPullService.class);
        startIntentService.putExtra("geweiIntentService", "IntentService Message");
        this.startService(startIntentService);
    }

    public void stopIntentService(View view) {

    }
}
