package com.zdn.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产消费模型
 * 练习ReentrantLock和Condition
 * 生产消费交替进行
 */
public class Good {

    ReentrantLock lock = new ReentrantLock();

    Condition condition = lock.newCondition();

    boolean flag = false;
    /**
     * 产品个数
     */
    int number = 1;

    public void product(){
        try {
            lock.lock();
            while (flag){
              // 生产者等待
              condition.await();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
