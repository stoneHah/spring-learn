package com.zq.learn.springlearn.aop;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AopConfig.class);
        ac.getBean(Waiter.class);
        Waiter waitProxy = (Waiter) ac.getBean("waitProxy");
        waitProxy.greetTo("qun.zheng");
        waitProxy.serveTo("ye.chen");

        Seller sellerProxy = (Seller) ac.getBean("sellerProxy");
        sellerProxy.greetTo("xss");

        String[] beanNames = ac.getBeanNamesForType(FactoryBean.class);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }


    }
}
