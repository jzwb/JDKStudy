package com.jzwbxx.jvm.classloader;

/**
 * 类加载子系统
 * 进行类初始化函数时，如果当前类有父类，则先执行父类的类初始化方法
 * 
 */
public class ClinitTest1 {

    static class Father {
        public static int a = 1;

        static {
            a = 2;
        }
    }

    static class Son extends Father {
        public static int b = a;
    }

    public static void main(String[] args) {
        //先加载Father类，其次再加载Son
        System.out.println(Son.b);//2
    }
}