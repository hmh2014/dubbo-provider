package com.hmh.dubbo.dao;

import test.hmh.vo.Person;

/**
 * Created by hao on 2017/4/17.
 */
public interface RedisDemoDao {

    public void set(String key, String value);

    public String get(String key);

    public void delete(String key);

    public void saveObject(Person person);

    public Person queryObject(String key);

    public void deleteObject(String key);
}
