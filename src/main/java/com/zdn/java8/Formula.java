package com.zdn.java8;

public interface Formula {

    double calc();

    default int add(int a,int b){
        return a + b;
    }
}
