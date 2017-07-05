package com.cat.controller;

import com.cat.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wangxiaoqiang on 2017/7/4.
 */
@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/test")
    public Object hello() {
        String s = helloService.printHello();
        return JSON.toJSON(s);
    }

    @RequestMapping(value = "/echo")
    public Object echo(HttpServletRequest request) {
        String parm = request.getParameter("key");

        String s = helloService.echo(parm);
        return JSON.toJSON(s);
    }
}
