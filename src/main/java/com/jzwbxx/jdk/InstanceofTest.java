package com.jzwbxx.jdk;

/**
 * 实例所对应的类存在继承关系时，测试instancceof修饰符的结果
 */
public class InstanceofTest {

    public static void main(String[] args) {
        SonService sonService = new SonServiceImpl();
        System.out.println("sonService instanceof SonServiceImpl = " + (sonService instanceof SonServiceImpl));//true
        System.out.println("sonService instanceof FatherServiceImpl = " + (sonService instanceof FatherServiceImpl));//true
        System.out.println("sonService instanceof SonService = " + (sonService instanceof SonService));//true
        System.out.println("sonService instanceof FatherService = " + (sonService instanceof FatherService));//true
        System.out.println("=============");
        FatherService fatherService1 = new SonServiceImpl();
        System.out.println("fatherService1 instanceof SonServiceImpl = " + (fatherService1 instanceof SonServiceImpl));//true
        System.out.println("fatherService1 instanceof FatherServiceImpl = " + (fatherService1 instanceof FatherServiceImpl));//true
        System.out.println("fatherService1 instanceof SonService = " + (fatherService1 instanceof SonService));//true
        System.out.println("fatherService1 instanceof FatherService = " + (fatherService1 instanceof FatherService));//true
        System.out.println("=============");
        FatherService fatherService2 = new FatherServiceImpl();
        System.out.println("fatherService2 instanceof SonServiceImpl = " + (fatherService2 instanceof SonServiceImpl));//false
        System.out.println("fatherService2 instanceof FatherServiceImpl = " + (fatherService2 instanceof FatherServiceImpl));//true
        System.out.println("fatherService2 instanceof SonService = " + (fatherService2 instanceof SonService));//false
        System.out.println("fatherService2 instanceof FatherService = " + (fatherService2 instanceof FatherService));//true
        
    }
    
    interface SonService extends FatherService{
        void sonSay();
    }
    
    interface FatherService{
        void fatherSay();
    }

    static class SonServiceImpl extends FatherServiceImpl implements SonService{
        @Override
        public void sonSay() {
            System.out.println("sonSay:hello!");
        }
    }

    static class FatherServiceImpl implements FatherService{
        @Override
        public void fatherSay() {
            System.out.println("fatherSay:hello!");
        }
    }
}