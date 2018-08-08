package com.example.suweikai.espressotest;

/**
 * Created by suweikai on 2018/8/8.
 */

public class Calculator {
    int add(int... nums){
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        return sum;
    }
}
