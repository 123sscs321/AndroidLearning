package com.byd.myapplication.jniutil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.byd.myapplication.R;

public class JniUtilsActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jni_utils);
        textView=findViewById(R.id.jni_textView);
        textView.setText(JniUtils.getJni());
    }

    public void cipJni(View view){
        textView.setText(JniUtils.getGewei());
    }
}
