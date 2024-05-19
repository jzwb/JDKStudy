package com.jzwbxx.jvm.stack;

/**
 * 虚拟机栈 - 栈帧
 * 结构：局部变量表、操作数栈、动态链接，方法返回地址、一些附加信息
 */
public class StackFrameTest {
    public static void main(String[] args) {
        method1();
    }

    private static void method1() {
        System.out.println("开始method1");
        method2();
        System.out.println("结束method1");
    }

    private static void method2() {
        System.out.println("开始method2");
        method3();
        System.out.println("结束method2");
    }

    private static void method3() {
        System.out.println("开始method3");
        System.out.println("结束method3");
    }
}
