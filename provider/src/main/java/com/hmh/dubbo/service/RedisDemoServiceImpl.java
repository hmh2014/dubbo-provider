package com.hmh.dubbo.service;

import com.hmh.dubbo.dao.RedisDemoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.hmh.service.RedisDemoService;
import test.hmh.vo.Person;

/**
 * Created by hao on 2017/4/16.
 */
@Service("redisDemoService")
public class RedisDemoServiceImpl implements RedisDemoService{

    @Autowired
    private RedisDemoDao redisDemoDao;

    @Override
    public String addString(String key, String value) {
        System.out.println("添加key " + key);
        redisDemoDao.set(key, value);
        return null;
    }

    @Override
    public String getString(String key) {
        String result = redisDemoDao.get(key);
        System.out.println("获取key " + key + ":" +result);
        return result;
    }

    @Override
    public String deleteString(String key) {
        redisDemoDao.delete(key);
        System.out.println("删除key " + key);
        return null;
    }

    @Override
    public String saveObject(Person person) {
        System.out.println("添加对象 " + person.toString());
        redisDemoDao.saveObject(person);
        return null;
    }

    @Override
    public Person queryObject(String key) {
        Person person = redisDemoDao.queryObject(key);
        if (person != null) {
            System.out.println("获取对象 " + person.toString());
            return person;
        } else {
            System.out.println("对象为空 " + person.toString());
        }
        return null;
    }

    @Override
    public String deleteObject(String s) {
        return null;
    }
}
