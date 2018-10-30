package com.levent_j.eatwaht.random;

import java.util.ArrayList;

/**
 * @auther : levent_j on 2018/10/28.
 * @desc :
 */
public interface IFoodRandomView {
    void onGetRandomItem(String s);
    void onGetAllItems(ArrayList<String> result);
}
