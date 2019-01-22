package com.zdn.pattern.factory.abstractmethod.demo;

public class BananaSmallIceCream implements SmallIceCream{

    @Override
    public void taste() {
        System.out.println("小杯的香蕉味冰淇淋");
    }
}
