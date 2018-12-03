package com.zq.learn.springlearn.aop;

import org.springframework.stereotype.Component;

@Component
public class NativeWaiter implements Waiter {
    @Override
    public void greetTo(String name) {
        System.out.println("greet to " + name + "...");
    }

    @Override
    public void serveTo(String name) {
        System.out.println("serving to " + name + "...");
    }
}
