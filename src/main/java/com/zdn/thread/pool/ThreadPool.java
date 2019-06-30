package com.zdn.thread.pool;

import java.util.concurrent.*;

public class ThreadPool {

    public static void main(String[] args) throws InterruptedException {
        /**
         * corePollSize：核心线程数。在创建了线程池后，线程中没有任何线程，等到有任务到来时才创建线程去执行任务。
         * 默认情况下，在创建了线程池后，线程池中的线程数为0，当有任务来之后，就会创建一个线程去执行任务，当线程池
         * 中的线程数目达到corePoolSize后，就会把到达的任务放到缓存队列当中。
         *
         * maximumPoolSize：最大线程数。表明线程中最多能够创建的线程数量。
         *
         * keepAliveTime：空闲的线程保留的时间。
         *
         * TimeUnit：空闲线程的保留时间单位。
         *
         * BlockingQueue<Runnable>：阻塞队列，存储等待执行的任务。参数有ArrayBlockingQueue、LinkedBlockingQueue、SynchronousQueue可选。
         *
         * ThreadFactory：线程工厂，用来创建线程
         *
         * RejectedExecutionHandler：队列已满，而且任务量大于最大线程的异常处理策略。有以下取值
         * 以下是异常处理策略具体内容
         * ThreadPoolExecutor.AbortPolicy:丢弃任务并抛出RejectedExecutionException异常。
         * ThreadPoolExecutor.DiscardPolicy：也是丢弃任务，但是不抛出异常。
         * ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
         * ThreadPoolExecutor.CallerRunsPolicy：由调用线程处理该任务
         */
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(6, 20, 20
                , TimeUnit.MINUTES, new LinkedBlockingDeque<>());

        // 方法用于提交不需要返回值的任务，所以无法判断任务是否被线程池执行成功与否；
        poolExecutor.execute(() -> {
            for (int i = 0; i < 2; i++) {
                System.out.println(Thread.currentThread().getName() + " execute:" + i);
            }
        });

        // 方法用于提交需要返回值的任务。线程池会返回一个Future类型的对象，通过这个Future对象可以判断任务是否执行成功，
        // 并且可以通过future的get()方法来获取返回值，get()方法会阻塞当前线程直到任务完成，而使用 get（long timeout，TimeUnit unit）
        // 方法则会阻塞当前线程一段时间后立即返回，这时候有可能任务没有执行完。
        Future<String> submit = poolExecutor.submit(() -> {
            for (int i = 0; i < 2; i++) {
                System.out.println(Thread.currentThread().getName() + " submit:" + i);
            }
            return "ok";
        });
        System.out.println("isDone: " + submit.isDone());

        try {
            System.out.println("retVal: " + submit.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        /*通过Executor 框架的工具类Executors来实现 我们可以创建三种类型的ThreadPoolExecutor：
        FixedThreadPool ： 该方法返回一个固定线程数量的线程池。该线程池中的线程数量始终不变。当有一个新的任务提交时，
        线程池中若有空闲线程，则立即执行。若没有，则新的任务会被暂存在一个任务队列中，待有线程空闲时，便处理在任务队列中的任务。
        SingleThreadExecutor： 方法返回一个只有一个线程的线程池。若多余一个任务被提交到该线程池，任务会被保存在一个任务队列中，
        待线程空闲，按先入先出的顺序执行队列中的任务。
        CachedThreadPool： 该方法返回一个可根据实际情况调整线程数量的线程池。线程池的线程数量不确定，但若有空闲线程可以复用，
        则会优先使用可复用的线程。若所有线程均在工作，又有新的任务提交，则会创建新的线程处理任务。所有线程在当前任务执行完毕后，
        将返回线程池进行复用。
        
        https://blog.csdn.net/qq_36520235/article/details/81539770
        */

        poolExecutor.shutdown();
    }
}
