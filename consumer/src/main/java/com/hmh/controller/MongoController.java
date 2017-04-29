package com.hmh.controller;

import com.hmh.util.Encoding;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import test.hmh.service.MongodbDemoService;
import test.hmh.vo.Person;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by hao on 2017/4/17.
 */
@Controller
@Scope("prototype")
@RequestMapping("/mongo")
public class MongoController {

    @Resource(name = "mongodbDemoService")
    private MongodbDemoService mongodbDemoService;

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPerson() {
        for (int i = 0; i < 10; i++)
        {
            Person p = new Person();
            p.setName("达康" + i);
            p.setAge(i);
            mongodbDemoService.add(p);
        }
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{value}", method = RequestMethod.GET)
    public String deletePerson(@PathVariable String value) {
        mongodbDemoService.delete("name", Encoding.encodeStr(value));
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/queryall", method = RequestMethod.GET)
    public String queryPerson() {
        List<Person> persons = mongodbDemoService.queryAll();
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/queryone/{value}", method = RequestMethod.GET)
    public String queryOne(@PathVariable String value) {
        Person person = mongodbDemoService.queryOne("name", Encoding.encodeStr(value));
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/update/{old}/{nnew}", method = RequestMethod.GET)
    public String updatePerson(@PathVariable String old, @PathVariable String nnew) {
        mongodbDemoService.update("name", Encoding.encodeStr(old), Encoding.encodeStr(nnew));
        return null;
    }
}
