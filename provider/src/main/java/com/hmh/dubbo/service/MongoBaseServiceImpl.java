package com.hmh.dubbo.service;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.dao.DAO;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.QueryResults;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;
import test.hmh.service.IMongoBaseService;

import java.io.Serializable;

/**
 * Created by hao on 2017/4/16.
 */
public class MongoBaseServiceImpl<T, K> implements IMongoBaseService<T, K>, Serializable {

    private DAO<T, K> baseDao;

    public long count()
    {
        return baseDao.count();
    }

    public long count(Query<T> q)
    {
        return baseDao.count(q);
    }

    public long count(String key, Object value)
    {
        return baseDao.count(key, value);
    }

    public void delete(T entity)
    {
        baseDao.delete(entity);
    }

    public void deleteById(K id)
    {
        baseDao.deleteById(id);
    }

    public void deleteByQuery(Query<T> q)
    {
        baseDao.deleteByQuery(q);
    }

    public boolean exists(Query<T> q)
    {
        return baseDao.exists(q);
    }

    public boolean exists(String key, Object value)
    {
        return baseDao.exists(key, value);
    }

    public QueryResults<T> find()
    {
        return baseDao.find();
    }

    public QueryResults<T> find(Query<T> q)
    {
        return baseDao.find(q);
    }

    public T findOne(Query<T> q)
    {
        return (T) baseDao.findOne(q);
    }

    public T findOne(String key, Object value)
    {
        return (T) baseDao.findOne(key, value);
    }

    public Key<T> save(T entity)
    {
        return baseDao.save(entity);
    }

    public DAO getBaseDao()
    {
        return baseDao;
    }

    public void setBaseDao(DAO baseDao)
    {
        this.baseDao = baseDao;
    }

    public Datastore getDatastore()
    {
        return baseDao.getDatastore();
    }

    public T get(K id)
    {
        return (T) baseDao.get(id);
    }

    public Query<T> createQuery()
    {
        return baseDao.createQuery();
    }

    public UpdateOperations<T> createUpdateOperations() { return baseDao.createUpdateOperations(); }

    public UpdateResults updateFirst(Query<T> query, UpdateOperations<T> updateOperations) {
        return baseDao.updateFirst(query, updateOperations);
    }
}
