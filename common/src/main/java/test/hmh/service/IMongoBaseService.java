package test.hmh.service;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.QueryResults;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

/**
 * Created by hao on 2017/4/16.
 */
public interface IMongoBaseService<T, K>  {

    public long count();
    public long count(Query<T> q);
    public long	count(String key, Object value) ;
    public void	delete(T entity) ;
    public void	deleteById(K id);
    public void	deleteByQuery(Query<T> q) ;
    public boolean	exists(Query<T> q);
    public boolean	exists(String key, Object value) ;
    public QueryResults<T> find();
    public QueryResults<T>	find(Query<T> q) ;
    public T findOne(Query<T> q) ;
    public T findOne(String key, Object value) ;
    public Key<T> save(T entity) ;
    public Datastore getDatastore();
    public T get(K id) ;
    public Query<T> createQuery() ;
    public UpdateOperations<T> createUpdateOperations() ;
    public UpdateResults updateFirst(Query<T> q, UpdateOperations<T> ops) ;
}
