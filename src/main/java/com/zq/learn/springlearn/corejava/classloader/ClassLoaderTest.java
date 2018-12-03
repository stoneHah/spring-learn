package com.zq.learn.springlearn.corejava.classloader;

/**
 *
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        testClassLoaderCategory();
    }

    /**
     * 测试类加载器的分类
     */
    private static void testClassLoaderCategory() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        System.out.println("当前类加载上下文:" + contextClassLoader);
        System.out.println("parent Class loader:" + contextClassLoader.getParent());
        System.out.println("grandparent Class loader:" + contextClassLoader.getParent().getParent());

    }
}
