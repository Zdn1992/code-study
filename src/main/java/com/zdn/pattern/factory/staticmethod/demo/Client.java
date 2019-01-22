package com.zdn.pattern.factory.staticmethod.demo;

public class Client {

    public static void main(String[] args) {
        String taste = "Apple";
        IceCream iceCream = IceCreamFactory.getIceCream(taste);
        iceCream.taste();
    }
}
