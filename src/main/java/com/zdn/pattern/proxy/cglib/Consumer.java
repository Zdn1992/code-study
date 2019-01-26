package com.zdn.pattern.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;


public class Consumer {

    public static void main(String[] args) {
        CompanyFactory company = new CompanyFactory();
        System.out.println("顾客直接把钱付给厂家");
        company.sale(50.0);
        CompanyFactory agent = (CompanyFactory) getCglibProxy(company);
        System.out.println("顾客把钱付给代理商");
        agent.sale(50.0);
    }

    private static Object getCglibProxy(final CompanyFactory company){
        return Enhancer.create(company.getClass(),
                (MethodInterceptor) (o, method, objects, methodProxy) -> {
                    // 如果售价超过20,代理经销商从中抽取5元的佣金
                    Double originMoney = (Double) objects[0];
                    if (originMoney > 20) {
                        originMoney = originMoney - 5;
                    }
                    return method.invoke(company, originMoney);
        });
    }
}
