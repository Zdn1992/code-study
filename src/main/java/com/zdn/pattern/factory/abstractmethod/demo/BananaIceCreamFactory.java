package com.zdn.pattern.factory.abstractmethod.demo;

public class BananaIceCreamFactory implements IceCreamFactory {

    @Override
    public BigIceCream createBigIceCream() {
        return new BananaBigIceCream();
    }

    @Override
    public SmallIceCream createSmallIceCream() {
        return new BananaSmallIceCream();
    }
}
