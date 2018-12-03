package com.zq.learn.springlearn.ioc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {

    @Autowired
    private CompactDisc cd;

    @Autowired
    private MediaPlayer mediaPlayer;

    @Test
    public void testCDNotNull(){
        assertNotNull(cd);
    }

    @Test
    public void testPlay(){
        mediaPlayer.play();
    }
}
