package com.hmh.controller;

import com.hmh.util.Encoding;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import test.hmh.service.RedisDemoService;
import test.hmh.vo.Person;

import javax.annotation.Resource;

/**
 * Created by hao on 2017/4/18.
 */
@Controller
@Scope("prototype")
@RequestMapping("/redis")
public class RedisController {

    @Resource(name = "redisDemoService")
    private RedisDemoService redisDemoService;

    @ResponseBody
    @RequestMapping(value = "/person/add", method = RequestMethod.GET)
    public String addPerson() {
        Person person = new Person();
        person.setName("沙书");
        person.setAge(50);
        redisDemoService.saveObject(person);
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/person/get/{key}", method = RequestMethod.GET)
    public String getPerson(@PathVariable String key) {
        key = Encoding.encodeStr(key);
        redisDemoService.queryObject(key);
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{key}", method = RequestMethod.GET)
    public String delete(@PathVariable String key) {
        redisDemoService.deleteString(Encoding.encodeStr(key));
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/string/add", method = RequestMethod.GET)
    public String addString() {
        for (int i = 0; i < 10; i++)
        {
            redisDemoService.addString("test" + i, "0" + i);
        }
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/string/get/{key}", method = RequestMethod.GET)
    public String getString(@PathVariable String key) {
        redisDemoService.getString(Encoding.encodeStr(key));
        return null;
    }

}
