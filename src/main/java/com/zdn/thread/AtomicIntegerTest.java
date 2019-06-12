package com.zdn.thread;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * hello atomicInteger
 * JUC atomic包下
 */
@Slf4j
public class AtomicIntegerTest {

    private Integer count = 0;

    private AtomicInteger atomicCount = new AtomicInteger();

    public void increment(){
        atomicCount.incrementAndGet();
    }

    public int getCount(){
        return atomicCount.get();
    }

    public static void main(String[] args) {
        AtomicIntegerTest obj = new AtomicIntegerTest();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(8,8,1,TimeUnit.MINUTES
        ,new LinkedBlockingDeque<>());
        for (int i = 0; i < 100; i++) {
            executor.execute(() -> {
                // 线程不安全
                obj.count ++;
                // 线程安全
                obj.increment();
            });
        }
        log.info("count:{}",obj.count); // 可能不是100
        log.info("atomicCount:{}",obj.getCount());// 结果是100
        /*AtomicInteger 类的原理 线程安全原理简单分析
        AtomicInteger 类主要利用 CAS (compare and swap) + volatile 和 native 方法来保证原子操作，从而避免 synchronized 的高开销，
        执行效率大为提升。
        CAS的原理是拿期望的值和原本的一个值作比较，如果相同则更新成新的值。UnSafe 类的 objectFieldOffset() 方法是一个本地方法，
        这个方法是用来拿到“原来的值”的内存地址，返回值是 valueOffset。另外 value 是一个volatile变量，在内存中可见，
        因此 JVM 可以保证任何时刻任何线程总能拿到该变量的最新值。*/
        executor.shutdown();
    }
}
