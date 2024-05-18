package com.jzwbxx.jvm.classloader;

/**
 * 类加载子系统
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoaderTest t = new ClassLoaderTest();
        //对象由哪个类创建
        System.out.println(t.getClass());
        //获取是谁加载这个类，sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(t.getClass().getClassLoader());

        ClassLoader sysClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("sysClassLoader:" + sysClassLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2

        ClassLoader extClassLoader = sysClassLoader.getParent();
        System.out.println("extClassLoader:" + extClassLoader);//sun.misc.Launcher$ExtClassLoader@5cad8086

        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println("bootstrapClassLoader:" + bootstrapClassLoader);//试图获取引导类加载器，结果为null

        //String类是使用引导类加载器进行加载的->java的核心类库都是使用引导类加载器加载
        ClassLoader stringClassLoader = String.class.getClassLoader();
        System.out.println("stringClassLoader:" + stringClassLoader);//null
    }
}