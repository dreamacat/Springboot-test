package com.cat.controller;

import com.cat.model.User;
import com.cat.service.user.IUserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangxiaoqiang on 2017/7/6.
 */
@RestController
@RequestMapping("/user")
//@Api(value = "User", description = "用户信息")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value={"/testStr"}, method= RequestMethod.GET)
    @ApiOperation(value="返回hello ", notes="返回hello + name")
    public Object TestStr(@ApiParam(required=true, name="name", value="姓名")
                              @RequestParam(name = "name", required=true) String name){
        return "Hello "+ name;
    }
    @RequestMapping("/getUserByName")
    @ApiOperation(value = "获取cat信息")
    public Object getUserByName(){
        Map<String,String> param = new HashMap<>();
        param.put("username","cat");

        User user = null;
        try{
            user = userService.findUserByProperty(param);
        } catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }
}
