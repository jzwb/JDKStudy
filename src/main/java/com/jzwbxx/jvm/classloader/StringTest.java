package com.jzwbxx.jvm.classloader;

/**
 * 双亲委派机制
 * 当类给类加载器加载时，会向上委托父类加载器去加载，如果无法完成加载任务，子类加载器才会尝试自己区加载
 */
public class StringTest {
    public static void main(String[] args) {
        System.out.println("StringTest run main...");
        java.lang.String string = new java.lang.String();
        
        StringTest stringTest = new StringTest();
        System.out.println(stringTest.getClass().getClassLoader());

    }
}
