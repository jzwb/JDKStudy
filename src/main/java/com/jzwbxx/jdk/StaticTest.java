package com.jzwbxx.jdk;

/**
 * 静态代码块、普通代码块、构造函数执行顺序
 */
public class StaticTest {

    //类加载时候执行
    static {
        int a = 1;
        System.out.println("a = " + a);
    }

    // 当对象new时执行，优先级高于构造函数
    {
        int b = 2;
        System.out.println("b = " + b);
    }

    //当对象new时执行
    StaticTest() {
        int c = 3;
        System.out.println("c = " + c);
    }

    public static void main(String[] args) {
        System.out.println("StaticTest run main...");
        StaticTest staticTest = new StaticTest();

        int a = 1;
        {
            int b = 2;//变量b仅在{}范围生效
            b += a;
            System.out.println("b = " + b);
        }
        System.out.println("a = " + a);
    }
}