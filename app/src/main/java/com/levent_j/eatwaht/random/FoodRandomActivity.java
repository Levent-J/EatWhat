package com.levent_j.eatwaht.random;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.levent_j.eatwaht.R;
import com.levent_j.eatwaht.base.BaseActivity;
import com.levent_j.eatwaht.foodlist.FoodListActivity;

import java.util.Random;

/**
 * @auther : levent_j on 2018/10/28.
 * @desc :
 */
public class FoodRandomActivity extends BaseActivity implements IFoodRandomView, View.OnClickListener {

    private Button mStartRandom;

    private FoodRandomPresenter mRandomPresenter;

    @Override
    public int setLayout() {
        return R.layout.activity_food_main;
    }

    @Override
    public void init() {

        mStartRandom = findViewById(R.id.btn_start);
        mStartRandom.setOnClickListener(this);

        mRandomPresenter = new FoodRandomPresenter(this);
        addPresenter(mRandomPresenter);
    }

    public static void openActivity(BaseActivity activity){
        Intent intent = new Intent(activity,FoodRandomActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public void onRandomStart() {
        //做一些初始化
    }

    @Override
    public void onRandomComplete(String result) {
        //展示结果
        mStartRandom.setText(result);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start:
                //如果可以点击的话
                mRandomPresenter.getRandomItem();
                break;
        }
    }
}
