package com.jzwbxx.jdk;

import com.jzwbxx.jdk.service.MyService;

import java.util.ServiceLoader;

/**
 * spi机制
 * 通过修改配置文件，动态加载接口实现
 */
public class SPITest {

    public static void main(String[] args) {
        //1、如果配置文件不存在或者配置文件内容为空，则返回空
        //2、配置文件可以配置一个或多个具体实现，则返回一个或多个
        //3、如果配置文件中配置类不存在，则抛出not found异常
        ServiceLoader<MyService> serviceLoader = ServiceLoader.load(MyService.class);
        for (MyService myService : serviceLoader) {
            myService.say();
        }
    }
}