package com.zdn.pattern.factory.method.demo;

public class OrangeIceCreamFactory implements IceCreamFactory {

    @Override
    public IceCream createIceCream() {
        return new OrangeIceCream();
    }
}
