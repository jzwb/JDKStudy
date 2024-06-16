package com.jzwbxx.jdk.service.impl;

import com.jzwbxx.jdk.service.MyService;

public class MyServiceImpl implements MyService {

    @Override
    public void say() {
        System.out.println("hello MyServiceImpl");
    }
}