package com.zq.learn.springlearn.aop;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class GreetingBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        if (!ArrayUtils.isEmpty(args) && args.length > 0) {
            System.out.println("How are you! Mr." + args[0] + ".");

        }
    }
}
