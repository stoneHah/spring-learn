package com.zq.learn.springlearn.ioc.advance.springel;

import com.zq.learn.springlearn.ioc.advance.profile.ProfileConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PropertiesConfig.class)
public class SpringELTest {

    @Autowired
    private Computer computer;

    @Test
    public void testComputer(){
        System.out.println(computer.getName());

        Map<String, Object> systemProperties = computer.getSystemProperties();
        systemProperties.forEach((key, value) -> {
            if (key.contains("computer")) {
                System.out.println("find...");
            }
            System.out.println(key + "=" + value);
        });
    }
}
