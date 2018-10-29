package com.levent_j.eatwaht.foodlist;

import android.content.Intent;

import com.levent_j.eatwaht.R;
import com.levent_j.eatwaht.base.BaseActivity;

/**
 * @auther : levent_j on 2018/10/28.
 * @desc :
 */
public class FoodListActivity extends BaseActivity{
    @Override
    public int setLayout() {
        return R.layout.activity_food_list;
    }

    @Override
    public void init() {

    }

    public static void openActivity(BaseActivity activity){
        Intent intent = new Intent(activity,FoodListActivity.class);
        activity.startActivity(intent);
    }
}
