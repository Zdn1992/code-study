package zdn.pattern.single;

/**
 * 线程安全的懒汉单例模式
 */
public class SingleDemo {

    private static SingleDemo singleDemo;

    // 私有化构造器
    private SingleDemo(){

    }

    public static SingleDemo getInstance(){
        // 当singleDemo不为null时,线程不会再进入同步方法
        if (singleDemo == null){
            synchronized (SingleDemo.class){
                // 若有多个线程通过了第一个if检验,则第二个if校验的作用是只new一个实例
                if (singleDemo == null){
                    singleDemo = new SingleDemo();
                }
            }
        }
        return singleDemo;
    }

}
