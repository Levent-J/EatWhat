package com.levent_j.eatwaht.base;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.levent_j.eatwaht.R;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseActivity extends AppCompatActivity {

    //当前Activity用到的presenter
    private List<BasePresenter> mPresenters = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //依次销毁presenter
        for (BasePresenter presenter : mPresenters) {
            presenter.onDestroy();
        }

        mPresenters.clear();

    }

    public void addPresenter(BasePresenter presenter) {
        mPresenters.add(presenter);
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slid_no);
    }

    @Override
    public void startActivity(Intent intent, @Nullable Bundle options) {
        super.startActivity(intent, options);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slid_no);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.slide_out_right);
    }

    //添加布局
    public abstract int setLayout();

    //初始化
    public abstract void init();


}
