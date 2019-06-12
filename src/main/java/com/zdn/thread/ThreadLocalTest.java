package com.zdn.thread;

import java.text.SimpleDateFormat;

/**
 * 练习ThreadLocal
 */
public class ThreadLocalTest implements Runnable {

    // SimpleDateFormat是线程不安全,ThreadLocal让每一个线程有自己独立的副本
    private ThreadLocal<SimpleDateFormat> format = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd HHmmss"));


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-> def format: " + format.get().toPattern());
        format.set(new SimpleDateFormat());
        System.out.println(Thread.currentThread().getName() + "-> update format: " + format.get().toPattern());
    }


    public static void main(String[] args) throws InterruptedException {
        ThreadLocalTest local = new ThreadLocalTest();
        for (int i = 0; i < 5; i++) {
            new Thread(local, "线程" + i).start();
            Thread.sleep(500);
        }
    }

    /*ThreadLocalMap 中使用的 key 为 ThreadLocal 的弱引用,而 value 是强引用。所以，如果 ThreadLocal 没有被外部强引用的情况下，
    在垃圾回收的时候会 key 会被清理掉，而 value 不会被清理掉。这样一来，ThreadLocalMap 中就会出现key为null的Entry。假如我们不
    做任何措施的话，value 永远无法被GC 回收，这个时候就可能会产生内存泄露。ThreadLocalMap实现中已经考虑了这种情况，在调用 set()、
    get()、remove() 方法的时候，会清理掉 key 为 null 的记录。使用完 ThreadLocal方法后 最好手动调用remove()方法*/

    /*static class Entry extends WeakReference<ThreadLocal<?>> {
        *//** The value associated with this ThreadLocal. *//*
        Object value;

        Entry(ThreadLocal<?> k, Object v) {
            super(k);
            value = v;
        }
    }*/

    /*弱引用介绍：

    如果一个对象只具有弱引用，那就类似于可有可无的生活用品。弱引用与软引用的区别在于：只具有弱引用的对象拥有更短暂的生命周期。
    在垃圾回收器线程扫描它 所管辖的内存区域的过程中，一旦发现了只具有弱引用的对象，不管当前内存空间足够与否，都会回收它的内存。
    不过，由于垃圾回收器是一个优先级很低的线程， 因此不一定会很快发现那些只具有弱引用的对象。

    弱引用可以和一个引用队列（ReferenceQueue）联合使用，如果弱引用所引用的对象被垃圾回收，Java虚拟机就会把这个弱引用加入到与
    之关联的引用队列中。*/
}
