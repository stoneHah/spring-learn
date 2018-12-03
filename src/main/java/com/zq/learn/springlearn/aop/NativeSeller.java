package com.zq.learn.springlearn.aop;

import org.springframework.stereotype.Component;

@Component
public class NativeSeller implements Seller {
    @Override
    public void greetTo(String name) {
        System.out.println("seller greet to " + name + "...");
    }

}
