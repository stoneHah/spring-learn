package com.zq.learn.springlearn.aop;

import com.zq.learn.springlearn.aop.advisor.GreetingAdvisor;
import org.junit.Before;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.RegexpMethodPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@ComponentScan
public class AopConfig {

    /**
     * if want to get factoryBean,the bean name
     * should start with '&'
     * @param waiter
     * @return
     */
   /* @Bean
    public ProxyFactoryBean waitProxy(Waiter waiter){
        ProxyFactoryBean factoryBean = new ProxyFactoryBean();
        factoryBean.setTarget(waiter);
        factoryBean.setProxyTargetClass(true);
        factoryBean.setInterceptorNames("greetingBeforeAdvice");
        return factoryBean;
    }*/

    @Bean
    public GreetingAdvisor greetingAdvisor(GreetingBeforeAdvice beforeAdvice){
        GreetingAdvisor greetingAdvisor = new GreetingAdvisor();
        greetingAdvisor.setAdvice(beforeAdvice);
        return greetingAdvisor;
    }

    @Bean
    public RegexpMethodPointcutAdvisor regexAdvisor(GreetingBeforeAdvice beforeAdvice){
        RegexpMethodPointcutAdvisor greetingAdvisor = new RegexpMethodPointcutAdvisor();
        greetingAdvisor.setPattern(".*greet.*");
        greetingAdvisor.setAdvice(beforeAdvice);
        return greetingAdvisor;
    }

    public ProxyFactoryBean greetingProxy(){
        ProxyFactoryBean factoryBean = new ProxyFactoryBean();
        factoryBean.setProxyTargetClass(true);
//        factoryBean.setInterceptorNames("greetingAdvisor");
        factoryBean.setInterceptorNames("regexAdvisor");
        return factoryBean;
    }

    @Bean
    public ProxyFactoryBean waitProxy(Waiter waiter) {
        ProxyFactoryBean proxy = greetingProxy();
        proxy.setTarget(waiter);
        return proxy;
    }

    @Bean
    public ProxyFactoryBean sellerProxy(Seller seller) {
        ProxyFactoryBean proxy = greetingProxy();
        proxy.setTarget(seller);
        return proxy;
    }

}
