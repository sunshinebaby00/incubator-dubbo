package com.alibaba.dubbo.examples.stub.impl;

import com.alibaba.dubbo.examples.stub.api.BarService;

public class BarServiceImpl implements BarService{
    @Override
    public String sayHello(String name) {
        return name;
    }
}
