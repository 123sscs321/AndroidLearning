package com.byd.mylibrary.animations.util;

import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.drawable.ShapeDrawable;

public class ShapeHolder {
    private float x=0,y=0;
    private ShapeDrawable shape;
    private int color;
    private RadialGradient gradient;
    private float alpha =1f;
    private Paint paint;

    public void setPaint(Paint value){
        paint=value;
    }

    public Paint getPaint(){
        return paint;
    }

    public void setX(float value) {
        x=value;
    }

    public float getX() {
        return x;
    }
}
