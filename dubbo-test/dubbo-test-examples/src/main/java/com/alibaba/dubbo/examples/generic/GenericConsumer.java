/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.dubbo.examples.generic;

import com.alibaba.dubbo.examples.generic.api.IUserService;
import com.alibaba.dubbo.examples.generic.api.IUserService.Params;
import com.alibaba.dubbo.examples.generic.api.IUserService.User;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.service.EchoService;
import com.alibaba.dubbo.rpc.service.GenericService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * GenericConsumer
 */
public class GenericConsumer {

    public static void main(String[] args) throws Exception {
        String config = GenericConsumer.class.getPackage().getName().replace('.', '/') + "/generic-consumer.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
        context.start();
      /*  IUserService userservice = (IUserService) context.getBean("userservice");
        User user = userservice.get(new Params("a=b"));
        System.out.println(user);
        System.in.read();*/

     /*   GenericService genericService = (GenericService) context.getBean("userservice");
        Object result = genericService.$invoke("get", new String[] { "com.alibaba.dubbo.examples.generic.api.IUserService.Params" }, new Object[] { new Params("a=c")});
        System.out.println(result);*/

        //回声测试
       /* IUserService userservice = (IUserService) context.getBean("userservice");
        System.out.println(userservice.get(new Params("hha")));
        EchoService echoService = (EchoService) userservice;
        Object status = echoService.$echo("ok");
        System.out.println("status="+status);
        System.in.read();*/


        IUserService userservice = (IUserService) context.getBean("userservice");
        System.out.println(userservice.get(new Params("hha")));

        // 本端是否为提供端，这里会返回true
        boolean isProviderSide = RpcContext.getContext().isProviderSide();
        // 获取调用方IP地址
        String clientIP = RpcContext.getContext().getRemoteHost();
        // 获取当前服务配置信息，所有配置信息都将转换为URL的参数
        String application = RpcContext.getContext().getUrl().getParameter("application");
        // 注意：每发起RPC调用，上下文状态会变化
        RpcContext.getContext().setAttachment("index","ok");
        userservice.get(new Params("hah"));
        // 此时本端变成消费端，这里会返回false
        boolean isProviderSide1 = RpcContext.getContext().isProviderSide();
    }
}
