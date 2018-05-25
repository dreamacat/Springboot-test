package com.cat.java8.stream;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wangxiaoqiang
 * @since 2018/05/21
 **/
public class Test {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("1","2","1");
        list.stream().filter((String s) -> s.equals("1")).collect((Collectors.toList())).forEach(s -> System.out.println(s));
    }
}
