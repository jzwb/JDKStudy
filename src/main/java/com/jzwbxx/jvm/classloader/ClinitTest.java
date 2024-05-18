package com.jzwbxx.jvm.classloader;

/**
 * 类加载子系统
 * 加载-链接-初始化
 * 链接：验证-准备-解析
 * 准备：为该类变量分配内存并且设置该类变量的默认初始值，即0值
 * final在编译的时候就会分配，准备阶段会显示初始化
 * 
 * <clinit>()函数初始化
 */
public class ClinitTest {

    private final static int testNum = 10;//链接的准备阶段会显示初始化
    
    private static int num = 1;//链接的准备阶段只会默认初始值

    static {
        num = 10;
        number = 2;
        System.out.println(num);//10
        //System.out.println(number);//报错，非法的前向引用
    }

    private static int number = 20;

    public static void main(String[] args) {
        System.out.println("num:" + num);//10
        System.out.println("number:" + number);//20
    }
}
