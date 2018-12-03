package com.zq.learn.springlearn.ioc.advance.condition;

import org.junit.Assert;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.mock.env.MockEnvironment;

import javax.crypto.Mac;

public class ConditionTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();

        MockEnvironment mockEnvironment = new MockEnvironment();
        mockEnvironment.setProperty("magic","zq");

        ConfigurableEnvironment environment = ac.getEnvironment();
        environment.merge(mockEnvironment);

        ac.register(ConditionConfiguration.class);
        ac.refresh();

        MagicBean magicBean = ac.getBean(MagicBean.class);
        System.out.println(magicBean.getDesc());


        ac.close();
    }
}
