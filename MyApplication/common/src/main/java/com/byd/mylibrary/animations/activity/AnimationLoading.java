package com.byd.mylibrary.animations.activity;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Shader;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.byd.mylibrary.R;
import com.byd.mylibrary.animations.util.ShapeHolder;

import java.util.ArrayList;

public class AnimationLoading extends Activity {
    @Override
    public void onCreate(Bundle savedState){
        super.onCreate(savedState);
        setContentView(R.layout.animation_loading);
        LinearLayout container=(LinearLayout)findViewById(R.id.container);

    }

    public class MyAnimationView extends View implements ValueAnimator.AnimatorUpdateListener{
        private static final int BALL_SIZE=100;
        public final ArrayList<ShapeHolder> balls=new ArrayList<ShapeHolder>();
        Animator animation =null;

        public MyAnimationView(Context context){
            super(context);
        }

        public void onAnimationUpdate(ValueAnimator animation){

        }
    }
}
