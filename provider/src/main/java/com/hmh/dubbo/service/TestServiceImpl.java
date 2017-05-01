package com.hmh.dubbo.service;

import org.springframework.stereotype.Service;
import test.hmh.service.TestService;

/**
 * @author hao
 * @date 2017/4/2923:54
 */
public class TestServiceImpl implements TestService {
    @Override
    public void test1(String name) {

    }

    @Override
    public void test(String name) {
        System.out.println( "hello, " + name );
    }
}
