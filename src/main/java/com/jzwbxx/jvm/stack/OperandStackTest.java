package com.jzwbxx.jvm.stack;

/**
 * 栈帧-操作数栈
 */
public class OperandStackTest {

    public static void main(String[] args) {
        OperandStackTest o = new OperandStackTest();
        o.add();
    }
    
    
    public void testAddOperation() {
        //byte、short、char、boolean
        byte i = 15;
        int j = 8;
        int k = i + j;

        //int m = 800;
    }
    
    public int getSum() {
        int m = 10;
        int n = 20;
        int k = m + n;
        return k;
    }
    
    public void testGetSum(){
        int i = getSum();//如果调用的方法有返回值的话，其返回值会被压入当前栈帧的操作数栈中
        int j = 10;
    }

    /**
     * 面试问题，常见的i++和++i的区别
     */
    public void add() {
        //第1类
        int i1 = 10;
        i1++;

        int i2 = 10;
        ++i2;

        //第2类
        int i3 = 10;
        int i4 = i3++;//10
        System.out.println("i4:" + i4);


        int i5 = 10;
        int i6 = ++i5;//11
        System.out.println("i6:" + i6);

        //第3类
        int i7 = 10;
        i7 = i7++;//10
        System.out.println("i7:" + i7);

        int i8 = 10;
        i8 = ++i8;//11
        System.out.println("i8:" + i8);

        //第4类
        int i9 = 10;
        int i10 = i9++ + ++i9;//21，错误，i9++是没有运算但是++i9运算后得到11，所以相加等于22
        System.out.println("i10:" + i10);
    }
}