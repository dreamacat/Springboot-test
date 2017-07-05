package com.cat.service.impl;

import com.cat.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * Created by wangxiaoqiang on 2017/7/4.
 */
@Service
public class HelloServiceImpl implements HelloService{
    @Override
    public String printHello() {
        return "hello cat";
    }

    @Override
    public String echo(String s) {
        return "I Love u " + s;
    }
}
