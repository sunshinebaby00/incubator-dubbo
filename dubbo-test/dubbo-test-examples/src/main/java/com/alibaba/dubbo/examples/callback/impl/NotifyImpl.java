package com.alibaba.dubbo.examples.callback.impl;

import java.util.HashMap;
import java.util.Map;
import com.alibaba.dubbo.examples.callback.api.*;
import com.alibaba.dubbo.examples.callback.bean.Person;
import org.springframework.stereotype.Component;

@Component
class NotifyImpl implements Notify {
    public Map<Integer, Throwable> errors = new HashMap<Integer, Throwable>();

    public void onreturn(Person person, Integer id) {
        System.out.println("onreturn:" + id);
    }

    public void onthrow(Throwable ex, Integer id) {
        errors.put(id, ex);
    }
}