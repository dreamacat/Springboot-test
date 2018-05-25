package com.cat.java8.lambda;

import lombok.Data;

import java.util.function.Predicate;

/**
 * @author wangxiaoqiang
 * @since 2018/05/24
 **/
@Data
public class Apple {
    private String color;
    private Integer wheight;

    public Apple() {
        color = "red";
        wheight = getDefaultWheight();
    }

    public Apple(String color) {
        this.color = color;
        wheight = getDefaultWheight();
    }

    public Apple(String color, Integer wheight) {
        this.color = color;
        this.wheight = wheight;
    }

    private int getDefaultWheight() {
        return (int) (Math.random() * 100) +1;
    }

    static Predicate<Apple> redApple = a -> a.getColor().equals("red");

    static Predicate<Apple> nice = redApple.negate().and(a -> a.getWheight() >50);
    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", wheight=" + wheight +
                '}';
    }
}
