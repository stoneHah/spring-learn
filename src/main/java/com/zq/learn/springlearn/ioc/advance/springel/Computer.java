package com.zq.learn.springlearn.ioc.advance.springel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Computer {

    @Value("#{environment['computer.name']}")
    private String name;


    @Value("#{systemProperties}")
    private Map<String, Object> systemProperties;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getSystemProperties() {
        return systemProperties;
    }

    public void setSystemProperties(Map<String, Object> systemProperties) {
        this.systemProperties = systemProperties;
    }
}
