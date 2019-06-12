package com.zdn.java8.function;

@FunctionalInterface
public interface Converter<F,T> {

    T convert(F f);
}
