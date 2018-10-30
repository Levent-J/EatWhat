package com.levent_j.eatwaht.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.levent_j.eatwaht.R;

import java.util.ArrayList;

/**
 * @auther : levent_j on 2018/10/30.
 * @desc :
 */
public class RandomView extends RelativeLayout{

    private RelativeLayout mCenter;
    private TextView mCenterFood;

    private IRandomView mRandomViewCallback;

    private ArrayList<String> mItems;
    private String mResult;
    private boolean isBtnEnable = true;

    public RandomView(Context context) {
        super(context);
    }

    public RandomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.view_random,this);

        mCenter = findViewById(R.id.rl_random_center);
        mCenterFood = findViewById(R.id.tv_random_center);
        mItems = new ArrayList<>();

        mCenter.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBtnEnable){
                    isBtnEnable = false;
                    mRandomViewCallback.onStartRandomView();

                    //开始所有的动画
                    startAnim();
                }

            }
        });

    }

    private void startAnim() {
        Animation scaleAnim = new ScaleAnimation(1.0f,0.5f,1.0f,0.5f,mCenter.getWidth()/2,mCenter.getHeight()/2);
        scaleAnim.setDuration(2000);
        scaleAnim.setRepeatMode(Animation.REVERSE);
        scaleAnim.setRepeatCount(1);
        mCenter.startAnimation(scaleAnim);


        AnimationSet animationSet = new AnimationSet(true);
        Animation textScaleAnim = new ScaleAnimation(1.0f,0.5f,1.0f,0.5f,mCenterFood.getWidth()/2,mCenterFood.getHeight()/2);
        textScaleAnim.setRepeatMode(Animation.REVERSE);
        textScaleAnim.setRepeatCount(1);
        Animation textAlphaAnim = new AlphaAnimation(1f,0f);
        textAlphaAnim.setRepeatMode(Animation.REVERSE);
        textAlphaAnim.setRepeatCount(1);
        Animation textRotateAnim =new RotateAnimation(0,720,mCenterFood.getWidth()/2,mCenterFood.getHeight()/2);
        textRotateAnim.setRepeatMode(Animation.REVERSE);
        textRotateAnim.setRepeatCount(1);
        animationSet.addAnimation(textScaleAnim);
        animationSet.addAnimation(textAlphaAnim);
        animationSet.addAnimation(textRotateAnim);
        animationSet.setDuration(2000);

        mCenterFood.startAnimation(animationSet);



        //最后恢复
        isBtnEnable = true;
    }

    public void setmRandomViewCallback(IRandomView mRandomViewCallback) {
        this.mRandomViewCallback = mRandomViewCallback;
    }

    public void setAllItems(ArrayList<String> result) {
        mItems.clear();
        mItems.addAll(result);
    }

    public void setResultItem(String s) {
        mResult = s;
//        mCenterFood.setText(s);
    }
}
