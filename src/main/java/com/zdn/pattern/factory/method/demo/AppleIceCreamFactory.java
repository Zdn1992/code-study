package com.zdn.pattern.factory.method.demo;

public class AppleIceCreamFactory implements IceCreamFactory {

    @Override
    public IceCream createIceCream() {
        return new AppleIceCream();
    }
}
