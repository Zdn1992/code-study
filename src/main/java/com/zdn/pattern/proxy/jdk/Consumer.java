package com.zdn.pattern.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * 消费者
 */
public class Consumer {

    public static void main(String[] args) {
        CompanyFactory company = new CompanyFactory();
        System.out.println("顾客直接把钱付给厂家");
        company.sale(50.0);
        IAgent agent = getJdkProxy(company);
        System.out.println("顾客把钱付给代理商");
        agent.sale(50.0);
    }

    private static IAgent getJdkProxy(final CompanyFactory company) {
        // 使用JDK官方的代理对象, 被代理对象和代理对象需要实现同一个接口
        return (IAgent) Proxy.newProxyInstance(CompanyFactory.class.getClassLoader(),
                CompanyFactory.class.getInterfaces(),

                (proxy, method, args) -> {
                    // 如果售价超过20,代理经销商从中抽取5元的佣金
                    Double originMoney = (Double) args[0];
                    if (originMoney > 20) {
                        originMoney = originMoney - 5;
                    }
                    return method.invoke(company, originMoney);
                });
    }
}
