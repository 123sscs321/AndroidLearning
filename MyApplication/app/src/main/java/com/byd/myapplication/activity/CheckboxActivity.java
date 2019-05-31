package com.byd.myapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.byd.myapplication.R;

public class CheckboxActivity extends Activity {
    private static final String TAG = "CheckboxActivity";
    private static final String FIRST_CHECKBOX_STATE = "first_checkbox_state";
    private static final String SECOND_CHECKBOX_STATE = "second_checkbox_state";
    private static final String THIRD_CHECKBOX_STATE = "third_checkbox_state";
    private CheckBox checkBox1, checkBox2, checkBox3;
    private TextView textView;
    private StringBuffer sb;
    private boolean checked1 = false, checked2 = false, checked3 = false;

    @Override
    public void onCreate(Bundle savedStates) {
        super.onCreate(savedStates);
        setContentView(R.layout.activity_checkbox);
        initView();
        initCheckboxState(savedStates);
        initData();
        setOnCheckboxClicked();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(FIRST_CHECKBOX_STATE, checkBox1.isChecked());
        outState.putBoolean(SECOND_CHECKBOX_STATE, checkBox2.isChecked());
        outState.putBoolean(THIRD_CHECKBOX_STATE, checkBox3.isChecked());
        Log.d(TAG, "onSaveInstanceState" + " " + checkBox1.isChecked() + " " + checkBox2.isChecked() + " " + checkBox3.isChecked());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedState){
        super.onRestoreInstanceState(savedState);
        Log.d(TAG,"onRestoreInstanceState");

    }

    private void initView() {
        checkBox1 = (CheckBox) findViewById(R.id.checkbox_1);
        checkBox2 = (CheckBox) findViewById(R.id.checkbox_2);
        checkBox3 = (CheckBox) findViewById(R.id.checkbox_3);
        textView = (TextView) findViewById(R.id.checkbox_content);
    }

    private void initCheckboxState(Bundle savedState){
        if (savedState !=null){
            checked1= savedState.getBoolean("1",false);
            checked2=savedState.getBoolean("2",false);
            checked3=savedState.getBoolean("3",false);
            checkBox1.setChecked(checked1);
            checkBox2.setChecked(checked2);
            checkBox3.setChecked(checked3);
        }
    }

    private void initData() {
        sb = new StringBuffer("");
        String text = "";
        int i = 0;
        if (checked1) {
            sb.append("chebox1");
            i++;
        }
        if (checked2) {
            sb.append("chebox2");
            i++;
        }
        if (checked3) {
            sb.append("chebox3");
            i++;
        }
        switch (i) {
            case 1:
                sb.append("预算剩余");
                break;
            case 3:
                sb.append("超出预算");
                break;
            default:
                break;
        }
        text = sb.toString();
        textView.setText(text);
    }

    private void setOnCheckboxClicked() {
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checked1 = isChecked;
                initData();
            }
        });

        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checked2 = isChecked;
                initData();
            }
        });

        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checked3 = isChecked;
                initData();
            }
        });
    }
}
