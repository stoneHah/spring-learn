package com.zq.learn.springlearn.aop;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Iterator;

public class AopAutoProxyTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AopAutoProxyConfig.class);
        Waiter waitProxy = (Waiter) ac.getBean("nativeWaiter");
//        Waiter waitProxy = ac.getBean(Waiter.class);
        waitProxy.greetTo("qun.zheng");
        waitProxy.serveTo("ye.chen");

        /*Seller sellerProxy = ac.getBean(Seller.class);
        sellerProxy.greetTo("xss");

        System.out.println("===================show bean names===============");
        Iterator<String> beanNamesIterator = ac.getDefaultListableBeanFactory().getBeanNamesIterator();
        while (beanNamesIterator.hasNext()) {
            System.out.println(beanNamesIterator.next());
        }

        String[] beanNames = ac.getBeanNamesForType(FactoryBean.class);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }*/
    }
}
