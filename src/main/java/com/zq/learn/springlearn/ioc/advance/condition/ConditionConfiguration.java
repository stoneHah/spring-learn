package com.zq.learn.springlearn.ioc.advance.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionConfiguration {

    @Bean
    @Conditional(MagicExistsCondition.class)
    public MagicBean magicBean(){
        return new MagicBean("magic bean");
    }

}
