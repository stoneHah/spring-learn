package com.zq.learn.springlearn.aop;

import org.springframework.aop.framework.ProxyFactory;

public class BeforeAdviceTest {
    public static void main(String[] args) {
        Waiter waiter = new NativeWaiter();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(waiter);

        GreetingBeforeAdvice greetingBeforeAdvice = new GreetingBeforeAdvice();
        proxyFactory.addAdvice(greetingBeforeAdvice);

        Waiter proxy = (Waiter) proxyFactory.getProxy();
        proxy.greetTo("SXQ");
        proxy.serveTo("CY");

    }
}
