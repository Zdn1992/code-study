package com.zdn.pattern.factory.method.demo;

public class BananaIceCreamFactory implements IceCreamFactory{
    @Override
    public IceCream createIceCream() {
        return new BananaIceCream();
    }
}
