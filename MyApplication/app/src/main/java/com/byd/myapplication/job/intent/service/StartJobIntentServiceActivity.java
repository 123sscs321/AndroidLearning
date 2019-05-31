package com.byd.myapplication.job.intent.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.byd.myapplication.R;

public class StartJobIntentServiceActivity extends Activity {

    @Override
    public void onCreate(Bundle savedStates) {
        super.onCreate(savedStates);
        setContentView(R.layout.activity_start_job_intent_service);
    }

    public void startJobIntentService(View view) {
        Intent jobIntentService = new Intent();
        jobIntentService.putExtra("label", "StartJobIntentServiceActivity");
        SimpleJobIntentService.enqueueWork(this, jobIntentService);
    }

    public void stopJobIntentService(View view) {

    }
}
