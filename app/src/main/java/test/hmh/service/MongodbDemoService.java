package test.hmh.service;

import org.bson.types.ObjectId;
import test.hmh.vo.Person;

import java.util.List;

/**
 * Created by hao on 2017/4/16.
 */
public interface MongodbDemoService extends IMongoBaseService<Person, ObjectId> {

    public String add(Person person);

    public List<Person> queryAll();

    public Person queryOne(String name, String value);

    public String update(String name, String oldValue, String newValue);

    public String delete(String name, String value);
}
