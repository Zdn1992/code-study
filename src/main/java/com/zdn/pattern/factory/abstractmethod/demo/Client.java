package com.zdn.pattern.factory.abstractmethod.demo;

public class Client {

    public static void main(String[] args) {
        // 苹果味各种型号的冰淇淋
        BigIceCream appleBigIceCream = new AppleIceCreamFactory().createBigIceCream();
        appleBigIceCream.taste();
        SmallIceCream appleSmallIceCream = new AppleIceCreamFactory().createSmallIceCream();
        appleSmallIceCream.taste();

        // 香蕉味各种型号的冰淇淋
        BigIceCream bananaBigIceCream = new BananaIceCreamFactory().createBigIceCream();
        bananaBigIceCream.taste();
        SmallIceCream bananaSmallIceCream = new BananaIceCreamFactory().createSmallIceCream();
        bananaSmallIceCream.taste();

        /*可以看到，之所以叫抽象工厂，是因为和工厂方法相比，这里有多个抽象产品类存在(即大份的冰激凌和小份的冰激凌)，
        每个抽象产品类可以派生出多个具体的产品，生产的是系列产品，其工厂接口相对于工厂方法模式而言，是有多个方法的，
        用来生产不同的抽象产品。*/
    }
}
