package com.levent_j.eatwaht.random;

import com.levent_j.eatwaht.base.BasePresenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
        Random random = new Random();
        String[] ss = new String[]{"粉面窗口","西餐窗口","卤味窗口","泰式窗口","干锅窗口","水煮窗口","自助窗口"};
        int index = random.nextInt(ss.length);
        iFoodRandomView.onGetRandomItem(ss[index]);
    }

    @Override
    public void onDestroy() {

    }

    public void getAllItems() {
        String[] ss = new String[]{"粉面窗口","西餐窗口","卤味窗口","泰式窗口","干锅窗口","水煮窗口","自助窗口"};
        ArrayList<String> list =new ArrayList<>();
        list.addAll(Arrays.asList(ss));
        iFoodRandomView.onGetAllItems(list);
    }
}
