package com.cat.controller;

import com.alibaba.fastjson.JSON;
import com.cat.service.HelloService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangxiaoqiang on 2017/7/4.
 */
@RestController
@Api(value = "hello", description = "测试")
public class HelloController {
    @Autowired
    HelloService helloService;

    @RequestMapping(value={"/echo"}, method= RequestMethod.POST)
    @ApiOperation(value="返回hello ", notes="返回hello + name")
    public Object echo(@ApiParam(name="name", value="姓名") @RequestParam(name = "name", required = true) String name) {
        String s = helloService.echo(name);
        return JSON.toJSON(s);
    }
}
