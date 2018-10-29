package com.levent_j.eatwaht.random;

import com.levent_j.eatwaht.base.BasePresenter;

import java.util.Random;

/**
 * @auther : levent_j on 2018/10/28.
 * @desc :
 */
public class FoodRandomPresenter extends BasePresenter {

    private IFoodRandomView iFoodRandomView;

    public FoodRandomPresenter(IFoodRandomView iFoodRandomView) {
        this.iFoodRandomView = iFoodRandomView;
    }

    public void getRandomItem(){
        iFoodRandomView.onRandomStart();
        Random random = new Random();
        String[] ss = new String[]{"粉面窗口","西餐窗口","卤味窗口","泰式窗口","干锅窗口","水煮窗口"};
        int index = random.nextInt(ss.length);
        iFoodRandomView.onRandomComplete(ss[index]);
    }

    @Override
    public void onDestroy() {

    }
}
