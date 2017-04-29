package com.hmh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import test.hmh.service.DubboService;

/**
 * Created by hao on 2017/4/15.
 */
public class Main {


    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:applicationContext.xml");
        context.start();

        DubboService dubboService = (DubboService) context.getBean("dubboService"); // 获取远程服务代理
        String ricky = dubboService.hello("ricky"); // 执行远程方法
        System.out.println(ricky); // 显示调用结果

    }
}
