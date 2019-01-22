package com.zdn.pattern.factory.method.demo;

public class BananaIceCream implements IceCream {

    @Override
    public void taste() {
        System.out.println("香蕉味的冰淇淋");
    }
}
