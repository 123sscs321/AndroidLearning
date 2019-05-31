package com.byd.myapplication.permission;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

public class PermissionActivity extends AppCompatActivity {
    private static final String TAG = "PermissionActivity";
    private static final int REQUSET_CODE = 1;
    private Context mContext;
    private String[] permissions = {Manifest.permission.SEND_SMS,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA};

    @Override
    public void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        mContext = this;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED ||
                ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||
                ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.SEND_SMS) ||
                    ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) ||
                    ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
                Log.d(TAG, " requestPermissions Again");
                //再次请求权限的地方
                ActivityCompat.requestPermissions(this, permissions, REQUSET_CODE);
            } else {
                //第一次请求权限的地方
                ActivityCompat.requestPermissions(this, permissions, REQUSET_CODE);
                Log.d(TAG, "requestPermissions ");
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume ");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUSET_CODE:
                if (verifyPermissions(grantResults)) {
                    Log.d(TAG, "permission was granted");

                } else {
                    Log.d(TAG, "permission was denied");
                    Toast.makeText(mContext, "仍有权限没有授权，应用功能受限", Toast.LENGTH_LONG).show();
                    //此处可以做跳转到应用权限界面的处理逻辑，让用户自己授权。
                }
                break;
            default:
                break;
        }
    }

    private boolean verifyPermissions(int[] grantResults) {
        if (grantResults.length < 1) {
            return false;
        }
        for (int result : grantResults) {
            if (result != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }
}
