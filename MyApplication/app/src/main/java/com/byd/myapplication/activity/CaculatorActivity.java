package com.byd.myapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.byd.myapplication.R;

public class CaculatorActivity extends Activity {
    private static final String TAG = "CaculatorActivity";
    private int firstInputValue, secondInputValue, operateValue = 0, resultValue;
    private TextView operateText, resultText;
    private EditText firstInput, secondInput;
    private Button addButton, substractButton, multiplyButton, divideButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caculate);
        initView();
        setOnClickListener();
        if (savedInstanceState != null) {
            operateValue = savedInstanceState.getInt("operate");
            switch (operateValue) {
                case 0:
                    operateText.setText("");
                    break;
                case 1:
                    operateText.setText("+");
                    break;
                case 2:
                    operateText.setText("-");
                    break;
                case 3:
                    operateText.setText("*");
                    break;
                case 4:
                    operateText.setText("/");
                    break;
                default:
                    operateText.setText("");
                    break;
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        caculateMethod();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("operate", operateValue);
    }

    private void initView() {
        operateText = (TextView) findViewById(R.id.caculate_operator);
        resultText = (TextView) findViewById(R.id.caculate_result);
        firstInput = (EditText) findViewById(R.id.caculate_input1);
        secondInput = (EditText) findViewById(R.id.caculate_input2);
        addButton = (Button) findViewById(R.id.caculate_button_add);
        substractButton = (Button) findViewById(R.id.caculate_button_substract);
        multiplyButton = (Button) findViewById(R.id.caculate_button_mult);
        divideButton = (Button) findViewById(R.id.caculate_button_div);
        firstInput.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        secondInput.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

    }

    private void setOnClickListener() {
        firstInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                caculateMethod();
                Log.d(TAG,"firstInput");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        secondInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                caculateMethod();
                Log.d(TAG,"secondInput");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operateText.setText("+");
                operateValue = 1;
                caculateMethod();
            }
        });

        substractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operateText.setText("-");
                operateValue = 2;
                caculateMethod();
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operateText.setText("*");
                operateValue = 3;
                caculateMethod();
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operateText.setText("/");
                operateValue = 4;
                caculateMethod();
            }
        });

    }

    private void caculateMethod() {
        if (firstInput.getText().toString().equals("")) {
            firstInputValue = 0;
        } else {
            firstInputValue = Integer.parseInt(firstInput.getText().toString());
        }
        if (secondInput.getText().toString().equals("")) {
            secondInputValue = 0;
        } else {
            secondInputValue = Integer.parseInt(secondInput.getText().toString());
        }
        if (resultText.getText().toString().equals("") || resultText.getText().toString().equals("error")) {
            resultValue = 0;
        } else {
            resultValue = Integer.parseInt(resultText.getText().toString());
        }
        switch (operateValue) {
            case 0:
                break;
            case 1:
                resultValue = firstInputValue + secondInputValue;
                break;
            case 2:
                resultValue = firstInputValue - secondInputValue;
                break;
            case 3:
                resultValue = firstInputValue * secondInputValue;
                break;
            case 4:
                if (secondInputValue != 0) {
                    resultValue = firstInputValue / secondInputValue;
                } else {
                    resultText.setText("error");
                    Log.d(TAG, "firstInputValue=" + firstInputValue + " secondInputValue=" + secondInputValue + " resultValue=error");
                    return;
                }
                break;
            default:
                break;
        }
        Log.d(TAG, "firstInputValue=" + firstInputValue + " secondInputValue=" + secondInputValue + " resultValue=" + resultValue);
        resultText.setText("" + resultValue);
    }

}
