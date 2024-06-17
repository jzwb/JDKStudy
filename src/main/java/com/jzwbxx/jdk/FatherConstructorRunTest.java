package com.jzwbxx.jdk;

/**
 * 父类构造函数是否在子类实例化下执行
 */
public class FatherConstructorRunTest {

    public static void main(String[] args) {
        Son son = new Son("张三");
        System.out.println("son.getName() = " + son.getName());
        System.out.println("son.getFatherName() = " + son.getFatherName());
    }

    static class Son extends Father {

        public Son(String name) {
            //如父类没有无参数构造函数，那么子类构造函数需要指定执行父构造函数方法
            //因为它原本会隐式调用super()
            super("李四");
            this.name = name;
        }
        
        /*public Son(String name, int age){
            this.name = name;
            this.age = age;
        }*/

        private String name;
        private int age;

        public String getName() {
            return name;
        }
    }

    static class Father {
        
        /*public Father() {
            System.out.println("father constructor");
            this.fatherName = "李四";
        }*/

        public Father(String fatherName) {
            System.out.println("father constructor2");
            this.fatherName = fatherName;
        }

        private String fatherName;

        public String getFatherName() {
            return fatherName;
        }
    }
}
