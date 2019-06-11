package com.zdn.lock;

/**
 * from  JavaGuide
 * 认识线程死锁:
 * 多个线程同时被阻塞，它们中的一个或者全部都在等待某个资源被释放。由于线程被无限期地阻塞，
 * 因此程序不可能正常终止。
 */
public class DeadLock {
    /**
     * 资源一
     */
    public static final Object resourceOne = new Object();

    /**
     * 资源二
     */
    public static final Object resourceTwo = new Object();

    public static void main(String[] args) {

        new Thread(() -> {
            synchronized (resourceOne) {
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + " 获取到了资源一");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(threadName + " 准备获取资源二");
                synchronized (resourceTwo){
                    System.out.println(threadName + " 获取到了资源二");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (resourceTwo){
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + " 获取到了资源二");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(threadName + " 准备获取资源一");
                synchronized (resourceOne) {
                    System.out.println(threadName + " 获取到了资源一");
                }
            }
        }).start();
    }

    /*死锁必须具备以下四个条件：
    互斥条件：该资源任意一个时刻只由一个线程占用。
    请求与保持条件：一个进程因请求资源而阻塞时，对已获得的资源保持不放。
    不剥夺条件:线程已获得的资源在末使用完之前不能被其他线程强行剥夺，只有自己使用完毕后才释放资源。
    循环等待条件:若干进程之间形成一种头尾相接的循环等待资源关系。*/

    /*如何避免线程死锁?
    我们只要破坏产生死锁的四个条件中的其中一个就可以了。

    破坏互斥条件

    这个条件我们没有办法破坏，因为我们用锁本来就是想让他们互斥的（临界资源需要互斥访问）。

    破坏请求与保持条件

    一次性申请所有的资源。

    破坏不剥夺条件

    占用部分资源的线程进一步申请其他资源时，如果申请不到，可以主动释放它占有的资源。

    破坏循环等待条件

    靠按序申请资源来预防。按某一顺序申请资源，释放资源则反序释放。破坏循环等待条件。

    我们对线程 2 的代码修改成下面这样就不会产生死锁了。*/
}
