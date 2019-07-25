package com.zq.learn.springlearn.env;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author qun.zheng
 * @description: TODO
 * @date 2019-07-2521:31
 */
public class PropertySourceTest {

    Map<String,Object> customerSource;

    @Before
    public void before(){
        customerSource = new HashMap<>();
        customerSource.put("hello", "chenye");
        customerSource.put("name", "sxx");

    }


    /**
     * 使用map作为属性源
     */
    @Test
    public void testMapPropertySource(){
        PropertySource mapSource = new MapPropertySource("mapSource", customerSource);
        assertEquals("chenye",mapSource.getProperty("hello"));
    }

    /**
     * 通过 addLast、addFist方法设置属性源的优先级
     */
    @Test
    public void testPropertySources(){
        MapPropertySource systemPropertySource = new MapPropertySource("systemProperties", (Map) System.getProperties());
        MutablePropertySources pss = new MutablePropertySources();

        pss.addLast(systemPropertySource);

        /**
         * 自定义系统属性变量，调用addFirst方法使之优先级高于系统属性源
         */
        customerSource.put("user.name", "sxx");
        pss.addFirst(new MapPropertySource("customerProperties",customerSource));

        assertEquals("sxx",fetchPropertyValue(pss,"user.name"));

//        printPropertySources(systemPropertySource);

    }

    private Object fetchPropertyValue(MutablePropertySources pss, String property) {
        for (PropertySource<?> propertySource : pss) {
            if (propertySource.containsProperty(property)) {
                return propertySource.getProperty(property);
            }
        }
        return null;
    }

    private void printPropertySources(EnumerablePropertySource ps) {
        String[] propertyNames = ps.getPropertyNames();
        for (String propertyName : propertyNames) {
            System.out.println(propertyName + "->" + ps.getProperty(propertyName));
        }
    }
}
