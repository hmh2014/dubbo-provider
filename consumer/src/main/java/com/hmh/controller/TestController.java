package com.hmh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import test.hmh.service.DubboService;

import javax.annotation.Resource;

/**
 * Created by hao on 2017/4/14.
 */
@Controller
public class TestController {

    @Resource(name = "dubboService")
    private DubboService dubboService;

    @RequestMapping(value = "/test")
    @ResponseBody
    public String testString() {
        String str = dubboService.hello("hmh");
        return str;
    }

    @ResponseBody
    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    public  String getPerson(@PathVariable String id) {
        return "add";
    }

    @ResponseBody
    @RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE)
    public String deletePerson(@PathVariable String id) {
        return "delete";
    }

    @ResponseBody
    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public String addPerson() {
        return "delete";
    }

    @ResponseBody
    @RequestMapping(value = "/person", method = RequestMethod.PUT)
    public  String updatePerson() {
        return "update";
    }
}
