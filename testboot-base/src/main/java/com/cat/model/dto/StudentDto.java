package com.cat.model.dto;

import lombok.Data;

/**
 * Created by wangxiaoqiang on 2017/10/18.
 */
@Data
public class StudentDto {
    private String num;
    private String name;
    private String grade;
    private String major;
    private int age;

    public int formatAge(int age) {
        return age++;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "num='" + num + '\'' +
                ", name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                ", major='" + major + '\'' +
                ", age=" + age +
                '}';
    }
}
