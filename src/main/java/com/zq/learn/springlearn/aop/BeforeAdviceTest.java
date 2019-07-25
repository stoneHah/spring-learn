package com.zq.learn.springlearn.aop;

import com.zq.learn.springlearn.aop.advisor.GreetingAdvisor;
import org.springframework.aop.framework.ProxyFactory;

public class BeforeAdviceTest {
    public static void main(String[] args) {
        Waiter waiter = new NativeWaiter();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(waiter);

        GreetingBeforeAdvice greetingBeforeAdvice = new GreetingBeforeAdvice();
//        proxyFactory.addAdvice(greetingBeforeAdvice);

        GreetingAdvisor greetingAdvisor = new GreetingAdvisor();
        greetingAdvisor.setAdvice(greetingBeforeAdvice);
        proxyFactory.addAdvisor(greetingAdvisor);

        Waiter proxy = (Waiter) proxyFactory.getProxy();
        proxy.greetTo("SXQ");
        proxy.serveTo("CY");

    }
}
