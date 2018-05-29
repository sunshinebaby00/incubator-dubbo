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
package com.alibaba.dubbo.examples.stub;

import com.alibaba.dubbo.examples.stub.api.BarService;
import com.alibaba.dubbo.examples.validation.ValidationProvider;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ValidationConsumer
 */
public class StubProvider {

    public static void main(String[] args) throws Exception {
        String config = StubProvider.class.getPackage().getName().replace('.', '/') + "/stub-provider.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
        context.start();
        System.in.read();
    }

}
