package com.hmh.dubbo.dao;

import com.hmh.dubbo.Util.SerializeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;
import test.hmh.vo.Person;

import java.io.Serializable;

/**
 * Created by hao on 2017/4/17.
 */
@Repository("redisDemoDao")
public class ReidsDemoImpl implements RedisDemoDao {

    @Autowired
    private RedisTemplate<Serializable, Serializable> redisTemplate;

    @Override
    public void set(String key, String value) {
        ValueOperations<Serializable, Serializable> ops = redisTemplate.opsForValue();
        ops.set(SerializeUtil.serialize(key), SerializeUtil.serialize(value));
    }

    @Override
    public String get(String key) {
        ValueOperations<Serializable, Serializable> ops = redisTemplate.opsForValue();
        byte[] keybyte = SerializeUtil.serialize(key);
        String value = (String) SerializeUtil.unserialize((byte[])ops.get(keybyte));
        return value;
    }

    @Override
    public void delete(String key) {
        redisTemplate.delete(SerializeUtil.serialize(key));
    }

    @Override
    public void saveObject(Person person) {
        ValueOperations<Serializable, Serializable> ops = redisTemplate.opsForValue();
        ops.set(SerializeUtil.serialize(person.getName()), SerializeUtil.serialize(person));
    }

    @Override
    public Person queryObject(String key) {
        ValueOperations<Serializable, Serializable> ops = redisTemplate.opsForValue();
        byte[] keybyte = SerializeUtil.serialize(key);
        Person person = (Person) SerializeUtil.unserialize((byte[]) ops.get(keybyte));
        return person;
    }

    @Override
    public void deleteObject(String key) {

    }

    public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
