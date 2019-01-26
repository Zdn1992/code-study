package com.zdn.pattern.proxy.jdk;

/**
 * 厂商的
 */
public class CompanyFactory implements IAgent {

    @Override
    public void sale(Double money) {
        System.out.println("厂家都到售卖货款: " + money);
    }

}
