package com.zq.learn.springlearn.ioc;

import org.springframework.stereotype.Component;

@Component
public class SgtPepper implements CompactDisc {
    @Override
    public void play() {
        System.out.println("playing fukua by chengyixun");
    }
}
