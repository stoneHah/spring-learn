package com.zq.learn.springlearn.aop;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AopConfig {

    /**
     * if want to get factoryBean,the bean name
     * should start with '&'
     * @param waiter
     * @return
     */
    @Bean
    public ProxyFactoryBean waitProxy(Waiter waiter){
        ProxyFactoryBean factoryBean = new ProxyFactoryBean();
        factoryBean.setTarget(waiter);
        factoryBean.setProxyTargetClass(true);
        factoryBean.setInterceptorNames("greetingBeforeAdvice");
        return factoryBean;
    }
}
