package com.hmh.dubbo.service;


import org.springframework.stereotype.Service;
import test.hmh.service.DubboService;

/**
 * Created by hao on 2017/4/15.
 */
public class DubboServiceImpl implements DubboService{
    @Override
    public String hello(String s) {
        return "my name is" + s;
    }
}
