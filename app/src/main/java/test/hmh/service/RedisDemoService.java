package test.hmh.service;

import test.hmh.vo.Person;

/**
 * Created by hao on 2017/4/16.
 */
public interface RedisDemoService {

    //添加字符类型
    public String addString(String key, String value);
    //获取字符类型
    public String getString(String key);
    //删除字符类型
    public String deleteString(String key);

    public String saveObject(Person person);

    public Person queryObject(String key);

    public String deleteObject(String key);
}
