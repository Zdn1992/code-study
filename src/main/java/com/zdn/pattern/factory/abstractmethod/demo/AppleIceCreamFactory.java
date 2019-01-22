package com.zdn.pattern.factory.abstractmethod.demo;

public class AppleIceCreamFactory implements IceCreamFactory {

    @Override
    public BigIceCream createBigIceCream() {
        return new AppleBigIceCream();
    }

    @Override
    public SmallIceCream createSmallIceCream() {
        return new AppleSmallIceCream();
    }
}
