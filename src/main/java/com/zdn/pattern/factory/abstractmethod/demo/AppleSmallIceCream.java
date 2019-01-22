package com.zdn.pattern.factory.abstractmethod.demo;

public class AppleSmallIceCream implements SmallIceCream {

    @Override
    public void taste() {
        System.out.println("小杯的苹果冰淇淋");
    }
}
