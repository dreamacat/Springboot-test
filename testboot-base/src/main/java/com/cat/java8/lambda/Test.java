package com.cat.java8.lambda;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author wangxiaoqiang
 * @since 2018/05/24
 **/
public class Test {

    public static void main(String[] args) {
//        List<Apple> appleList = Lists.newArrayList();
//        appleList.add(AppleFactory.p.get());
//        appleList.add(AppleFactory.f.apply("green"));
//        appleList.add(AppleFactory.b.apply("green", 10));
//        appleList.add(AppleFactory.b.apply("green", 100));
//
//        appleList.stream().filter(Apple.nice).forEach(System.out :: println);

        List<Integer> list = Lists.newArrayList(-2,-1,0,1,2,3);
        for (int i = 0; i < 3; i++) {
            list.remove(i);
        }
        list.forEach(System.out :: print);
        System.out.println();
        List<Integer> list2 = Lists.newArrayList(-2,-1,0,1,2,3);
        for (int i = 0; i < 3; i++) {
            list.remove(Integer.valueOf(i));
        }
        list.forEach(System.out :: print);

    }
}
