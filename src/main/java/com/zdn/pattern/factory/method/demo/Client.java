package com.zdn.pattern.factory.method.demo;

public class Client {

    public static void main(String[] args) {

        // 获取苹果味的冰淇淋
        IceCreamFactory appleFactory = new AppleIceCreamFactory();
        IceCream appleIceCream = appleFactory.createIceCream();
        appleIceCream.taste();

        // 获取香蕉味的冰淇淋
        IceCreamFactory bananaFactory = new BananaIceCreamFactory();
        IceCream bananaIceCream = bananaFactory.createIceCream();
        bananaIceCream.taste();

        // 获取橙子味的冰淇淋
        IceCreamFactory orangeFactory = new OrangeIceCreamFactory();
        IceCream orangeIceCream = orangeFactory.createIceCream();
        orangeIceCream.taste();

        // 可以看到，每个工厂只生产一种产品，客户端通过不同的工厂去生产不同的产品，而生产哪一产品的逻辑交给客户端这边去处理了。
    }
}
