package com.zdn.thread.lock;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {


    public static void main(String[] args) {
        MyService service = new MyService();
        ThreadA threadA = new ThreadA(service);
        ThreadB threadB = new ThreadB(service);
        new Thread(threadA, "线程一").start();
        new Thread(threadB, "线程二").start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 唤醒线程
        service.signallA();
        service.signallB();
    }


}

class ReentrantRun implements Runnable {

    ReentrantLock lock = new ReentrantLock();

    // 为线程

    @Override
    public void run() {
        try {
            lock.lock();
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + " excute: " + i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

class MyService {

    ReentrantLock lock = new ReentrantLock();

    // 为线程A注册一个Condition
    Condition conditionA = lock.newCondition();

    // 为线程B注册一个Condition
    Condition conditionB = lock.newCondition();

    public void awaitA() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "进入awaitA方法...");
            long beginTime = System.currentTimeMillis();
            conditionA.await();
            long endTime = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + "被唤醒,等待了:" + (endTime - beginTime) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void awaitB() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "进入awaitB方法...");
            long beginTime = System.currentTimeMillis();
            conditionA.await();
            long endTime = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + "被唤醒,等待了:" + (endTime - beginTime) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signallA() {
        try {
            lock.lock();
            // 唤醒所有注册conditionA的线程
            conditionA.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signallB() {
        try {
            lock.lock();
            // 唤醒所有注册conditionB的线程
            conditionB.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

class ThreadA implements Runnable {

    private MyService service;

    public ThreadA(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.awaitA();
    }
}

class ThreadB implements Runnable {

    private MyService service;

    public ThreadB(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.awaitB();
    }
}