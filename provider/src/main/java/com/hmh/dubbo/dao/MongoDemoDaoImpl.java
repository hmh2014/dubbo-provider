package com.hmh.dubbo.dao;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import test.hmh.vo.Person;

/**
 * Created by hao on 2017/4/16.
 */
public class MongoDemoDaoImpl extends BasicDAO<Person, ObjectId> implements MongoDemoDao {

    protected MongoDemoDaoImpl(Datastore ds)
    {
        super(ds);
    }

}
