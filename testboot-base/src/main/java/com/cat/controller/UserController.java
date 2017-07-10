package com.cat.controller;

import com.cat.model.bean.User;
import com.cat.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangxiaoqiang on 2017/7/6.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/")
    public Object TestStr(){
        return "Hello User";
    }

    @RequestMapping("/getUserByName")
    public User getUserByName(){
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
