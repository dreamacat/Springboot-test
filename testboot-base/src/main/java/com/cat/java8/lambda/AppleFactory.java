package com.cat.java8.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author wangxiaoqiang
 * @since 2018/05/24
 **/
public class  AppleFactory<T> {
    static Supplier<Apple> p = Apple :: new;
    static Function<String, Apple> f = Apple :: new;
    static BiFunction<String, Integer, Apple>  b = Apple :: new;

}
