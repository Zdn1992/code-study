package com.zdn.pattern.factory.staticmethod.demo;

public class IceCreamFactory {

    public static IceCream getIceCream(String taste) {
        IceCream iceCream = null;
        switch (taste) {
            case "Apple":
                iceCream = new AppleIceCream();
                break;
            case "BananaSmallIceCream":
                iceCream = new BananaIceCream();
                break;
            case "Orange":
                iceCream = new OrangeIceCream();
                break;
            default:
                break;
        }
        return iceCream;
    }
}
