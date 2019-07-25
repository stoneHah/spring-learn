package com.zq.learn.springlearn.aop;

import com.zq.learn.springlearn.aop.advisor.GreetingAdvisor;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.aop.support.RegexpMethodPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * ${DESCRIPTION}
 *
 * @author qun.zheng
 * @create 2018/12/3
 **/
@Configuration
@ComponentScan
public class AopAutoProxyConfig {

    /*@Bean
    public GreetingAdvisor greetingAdvisor(GreetingBeforeAdvice beforeAdvice){
        GreetingAdvisor greetingAdvisor = new GreetingAdvisor();
        greetingAdvisor.setAdvice(beforeAdvice);
        return greetingAdvisor;
    }*/

    /*@Bean
    public BeanNameAutoProxyCreator beanNameAutoProxyCreator(){
        BeanNameAutoProxyCreator autoProxyCreator = new BeanNameAutoProxyCreator();
        autoProxyCreator.setBeanNames("*er");
        autoProxyCreator.setInterceptorNames("greetingAdvisor");
        autoProxyCreator.setOptimize(true);
        return autoProxyCreator;
    }*/

    @Bean
    public RegexpMethodPointcutAdvisor regexAdvisor(GreetingBeforeAdvice beforeAdvice){
        RegexpMethodPointcutAdvisor greetingAdvisor = new RegexpMethodPointcutAdvisor();
        greetingAdvisor.setPattern(".*To.*");
        greetingAdvisor.setAdvice(beforeAdvice);
        return greetingAdvisor;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator creator =  new DefaultAdvisorAutoProxyCreator();
        creator.setOptimize(true);
        return creator;
    }
}
