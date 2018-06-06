package com.alibaba.dubbo.examples.callback.api;

import com.alibaba.dubbo.examples.callback.bean.Person;

public interface Notify {
     void onreturn(Person person, Integer id) ;
     void onthrow(Throwable ex, Integer id);
}
