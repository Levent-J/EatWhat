package com.levent_j.eatwaht.random;

import android.content.Intent;
import android.widget.Toast;

import com.levent_j.eatwaht.R;
import com.levent_j.eatwaht.base.BaseActivity;
import com.levent_j.eatwaht.views.IRandomView;
import com.levent_j.eatwaht.views.RandomView;

import java.util.ArrayList;

/**
 * @auther : levent_j on 2018/10/28.
 * @desc :
 */
public class FoodRandomActivity extends BaseActivity implements IFoodRandomView, IRandomView {

    private RandomView mRandomView;

    private FoodRandomPresenter mRandomPresenter;

    @Override
    public int setLayout() {
        return R.layout.activity_food_main;
    }

    @Override
    public void init() {

        mRandomView = findViewById(R.id.view_random);

        mRandomView.setmRandomViewCallback(this);

        mRandomPresenter = new FoodRandomPresenter(this);
        addPresenter(mRandomPresenter);

        mRandomPresenter.getAllItems();
    }

    public static void openActivity(BaseActivity activity){
        Intent intent = new Intent(activity,FoodRandomActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public void onGetRandomItem(String s) {
        //
        mRandomView.setResultItem(s);
    }

    @Override
    public void onGetAllItems(ArrayList<String> result) {
        //展示结果
        mRandomView.setAllItems(result);
    }


    @Override
    public void onStartRandomView() {
        mRandomPresenter.getRandomItem();
    }

    @Override
    public void onStopRandomView() {

    }
}
