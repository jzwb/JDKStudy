package com.jzwbxx.jvm.stack;

/**
 * 栈帧-局部变量表
 * 最基本存储单位为槽（slot），32bit的类型占用一个slot，64bit的类型占用两个slot
 */
public class LocalVariablesTest {

    public void a() {
        System.out.println("hello");
    }

    //slot的重复利用
    public void test1() {
        //icons_<i>，Push the int constant <i> (-1, 0, 1, 2, 3, 4 or 5) onto the operand stack.
        int a = 5;
        {//普通代码块
            int b = 6;//bipush
            b = a + b;
        }
        //变量c使用之前已经销毁的变量b占据的slot的位置
        int c = a + 7;
    }
}