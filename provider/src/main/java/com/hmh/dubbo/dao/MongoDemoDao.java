package com.hmh.dubbo.dao;

import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.DAO;
import test.hmh.vo.Person;

/**
 * Created by hao on 2017/4/16.
 */
public interface MongoDemoDao extends DAO<Person, ObjectId>{

}
