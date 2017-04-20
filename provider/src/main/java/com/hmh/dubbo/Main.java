package com.hmh.dubbo;

import com.hmh.dubbo.service.RedisDemoServiceImpl;
import org.mongodb.morphia.query.QueryResults;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import test.hmh.service.MongodbDemoService;
import test.hmh.service.RedisDemoService;
import test.hmh.vo.Person;

import java.io.IOException;

/**
 * Created by hao on 2017/4/15.
 */
public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:applicationContext.xml");
        context.start();

        System.out.println("dubbo start...");

        try {
            System.in.read();	// 按任意键退出
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
