package com.zq.learn.springlearn.ioc.advance.profile;

import com.zq.learn.springlearn.ioc.CDPlayerConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ProfileConfig.class)
@ActiveProfiles("prod")
public class ProfileTest {

    @Autowired
    private Application app;

    @Test
    public void testApp(){
        Assert.assertEquals("prod",app.getName());
    }
}
