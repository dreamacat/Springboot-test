package com.cat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * @author wangxiaoqiang
 *         create 2017/11/06
 **/
public class Test {
    private List<String> stringList = new ArrayList<>();

    public Test() {
        init();
    }

    public void init() {
        stringList.add("zzz1");
        stringList.add("aaa2");
        stringList.add("bbb2");
        stringList.add("fff1");
        stringList.add("fff2");
        stringList.add("aaa1");
        stringList.add("bbb1");
        stringList.add("zzz2");
    }

    public void useStreamFilter() {
        stringList.stream().filter(s -> s.startsWith("a")).map(String::toUpperCase).sorted((s1,s2) -> (s2.compareTo(s1))).forEach(System.out :: println);
    }

    public void useStreamMatch() {
        System.out.println(stringList.stream().anyMatch(s -> s.startsWith("a")));
        System.out.println(stringList.stream().allMatch(s -> s.startsWith("a")));
    }

    public void useStreamReduce() {
        Optional<String> reduced =  stringList.stream().sorted().reduce((s1, s2) -> s1 + "#" + s2);
        reduced.ifPresent(System.out::println);
        System.out.println(reduced.get());
    }

    public void useParallelStream() {
        // 初始化一个字符串集合
        int max = 1000000;
        List<String> values = new ArrayList<>();
        List<String> values2 = new ArrayList<>();

        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
            values2.add(uuid.toString());
        }
        long begin = System.nanoTime();
        values.stream().sorted();
        long end = System.nanoTime();
        System.out.println(end-begin);

        long parallelT0 = System.nanoTime();
        // default Stream<E> parallelStream() {
        // parallelStream为Collection接口的一个默认方法
        values2.parallelStream().sorted();
        long parallelT1 = System.nanoTime();

        System.out.println(parallelT1-parallelT0);

    }

    public void useMap() {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i<5; i++) {
            map.put(i+"", "va"+i);
        }
        map.putIfAbsent("0","6");
        map.put("1", "7");
        map.forEach((k,v) -> System.out.println(v));

    }
    public static void main(String[] args) {

        Test test = new Test();
        test.useMap();
    }
}
