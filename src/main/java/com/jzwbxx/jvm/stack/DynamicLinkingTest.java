package com.jzwbxx.jvm.stack;

/**
 * 栈帧-动态链接
 * 动态链接的主要作用是支持方法调用过程中的符号引用（Symbolic Reference）解析
 */
public class DynamicLinkingTest {
    public static void main(String[] args) {
        DynamicLinkingTest dynamicLinkingTest = new DynamicLinkingTest();
        dynamicLinkingTest.printMsg();
    }

    public void printMsg() {
        System.out.println("DynamicLinkingTest printMsg method!");
    }
}