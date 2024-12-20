/*
 *
 *   Licensed to the Apache Software Foundation (ASF) under one or more
 *   contributor license agreements.  See the NOTICE file distributed with
 *   this work for additional information regarding copyright ownership.
 *   The ASF licenses this file to You under the Apache License, Version 2.0
 *   (the "License"); you may not use this file except in compliance with
 *   the License.  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package org.apache.dubbo.samples.governance;

import org.apache.dubbo.samples.governance.api.DemoService;
import org.apache.dubbo.samples.governance.api.DemoService2;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

public class BasicConsumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/dubbo-demo-consumer.xml");
        context.start();

        DemoService demoService = context.getBean("demoService", DemoService.class);
        DemoService2 demoService2 = context.getBean("demoService2", DemoService2.class);

        String hello = demoService.sayHello("world");
        Assert.isTrue(hello.contains("28081"));
        Assert.isTrue(!hello.contains("gray"));
        System.out.println(hello);

        String hello2 = demoService2.sayHello("world again");
        Assert.isTrue(hello2.contains("28081"));
        Assert.isTrue(!hello.contains("gray"));
        System.out.println(hello2);
    }
}
