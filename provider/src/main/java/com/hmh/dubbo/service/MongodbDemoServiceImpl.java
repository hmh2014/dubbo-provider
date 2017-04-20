package com.hmh.dubbo.service;

import com.hmh.dubbo.dao.MongoDemoDao;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.QueryResults;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;
import test.hmh.service.MongodbDemoService;
import test.hmh.vo.Person;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by hao on 2017/4/16.
 */
public class MongodbDemoServiceImpl extends MongoBaseServiceImpl<Person, ObjectId> implements MongodbDemoService, Serializable{

    private MongoDemoDao mongoDemoDao;

    //添加
    @Override
    public String add(Person person) {
        Key<Person> key = save(person);
        System.out.println("添加对象 " + person.toString());
        return key.getId().toString();
    }

    //查询所有
    @Override
    public List<Person> queryAll() {
        System.out.println("查询所有对象 ");
        QueryResults<Person> persons = find();
        List<Person> list = persons.asList();
        if(list != null && list.size() > 0) {
            for (Person person : list)
            {
                System.out.println(person.toString());
            }
            return list;
        }
        return null;
    }

    //查询一个
    @Override
    public Person queryOne(String name, String value) {
        Query<Person> query = createQuery().field(name).equal(value);
        Person person = findOne(query);
        System.out.println("查询对象 " + person.toString());
        return person;
    }

    //更新
    @Override
    public String update(String name, String oldValue, String newValue) {
        //生成查询条件
        Query<Person> query = createQuery().field(name).equal(oldValue);
        //生成更新操作
        UpdateOperations<Person> ops = createUpdateOperations().set(name, newValue);
        UpdateResults res = updateFirst(query, ops);
        if(res.getUpdatedExisting()) {
            System.out.println("已更新" + oldValue + "->" + newValue);
        }
        return null;
    }

    //删除
    @Override
    public String delete(String name, String value) {
        //生成查询条件
        Query<Person> query = createQuery().field(name).equal(value);
        deleteByQuery(query);
        System.out.println("已删除 " + value);
        return null;
    }

    public MongoDemoDao getMongoDemoDao() {
        return mongoDemoDao;
    }

    public void setMongoDemoDao(MongoDemoDao mongoDemoDao) {
        this.mongoDemoDao = mongoDemoDao;
        super.setBaseDao(mongoDemoDao);
    }
}
