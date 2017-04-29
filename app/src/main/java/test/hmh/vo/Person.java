package test.hmh.vo;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.io.Serializable;

/**
 * Created by hao on 2017/4/14.
 */
@Entity
public class Person implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    private ObjectId id;
    private String name;
    private int age;

    public void setAge(int age) { this.age = age; }

    public ObjectId getId() { return id; }


    public void setId(ObjectId id) { this.id = id; }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
