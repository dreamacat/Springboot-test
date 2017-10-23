package com.cat.model.domain;

import lombok.Data;

import javax.persistence.Table;

/**
 * Created by wangxiaoqiang on 2017/9/13.
 */
@Table(name = "tb_student", schema = "catdb")
@Data
public class StudentDo {
    private String snum;
    private String sname;
    private String grade;
    private String major;
    private int age = 10;

    @Override
    public String toString() {
        return "StudentDo{" +
                "snum='" + snum + '\'' +
                ", sname='" + sname + '\'' +
                ", grade='" + grade + '\'' +
                ", major='" + major + '\'' +
                ", age=" + age +
                '}';
    }
}
