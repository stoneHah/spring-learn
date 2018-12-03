package com.zq.learn.springlearn.ioc.advance.profile;

public class Application {
    private String name;

    public Application(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
