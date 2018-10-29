package com.levent_j.eatwaht.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.levent_j.eatwaht.R;
import com.levent_j.eatwaht.base.BaseActivity;
import com.levent_j.eatwaht.foodlist.FoodListActivity;
import com.levent_j.eatwaht.random.FoodRandomActivity;

import java.util.Random;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button mFoodList;
    private Button mFoodRandom;

    @Override
    public int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
        mFoodList = findViewById(R.id.btn_food_list);
        mFoodRandom = findViewById(R.id.btn_food_random);

        mFoodList.setOnClickListener(this);
        mFoodRandom.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_food_list:
                FoodListActivity.openActivity(this);
                break;
            case R.id.btn_food_random:
                FoodRandomActivity.openActivity(this);
                break;
        }
    }
}
