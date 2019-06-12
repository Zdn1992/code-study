package com.zdn.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Zdn1992
 * 生产消费模型
 * 练习ReentrantLock和Condition
 * 生产消费交替进行
 */
public class Good {

    private ReentrantLock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    private boolean flag = false;
    /**
     * 产品个数
     */
    int number = 0;

    public void product(){
        try {
            lock.lock();
            while (flag){
              // 生产者等待
              condition.await();
            }
            number ++;
            System.out.println(Thread.currentThread().getName() + "生产商品,库存: " + number);
            Thread.sleep(500);
            flag = true;
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void consumer(){
        try {
            lock.lock();
            while (!flag){
                condition.await();
            }
            number --;
            System.out.println(Thread.currentThread().getName() + "消费商品,库存： " + number);
            Thread.sleep(500);
            flag = false;
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Good good = new Good();
        new Thread(() -> {
            for (;;){
                good.product();
            }
        },"生产者").start();
        new Thread(() -> {
            for (;;){
                good.consumer();
            }
        },"消费者").start();
    }
}
