package com.byd.myapplication.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.byd.myapplication.R;

public class ProgressDialogActivity extends Activity {
    private static final int PROGRESS_DIALOG_DIMISS = 0;
    private ProgressDialog progressDialog;
    private Handler myHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case PROGRESS_DIALOG_DIMISS:
                    progressDialog.dismiss();
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_dialog);
        TextView textView = (TextView) findViewById(R.id.progress_dialog_textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(ProgressDialogActivity.this);
                progressDialog.setTitle("请稍等片刻");
                progressDialog.setMessage("正在执行前端运算中...");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.setCancelable(false);
                progressDialog.show();
                myHandler.sendEmptyMessageDelayed(PROGRESS_DIALOG_DIMISS,6000);
            }
        });

    }
}
