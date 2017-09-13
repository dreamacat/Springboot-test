package com.cat.model.domain;

import lombok.Data;

import javax.persistence.Table;

/**
 * Created by wangxiaoqiang on 2017/9/13.
 */
@Table(name = "tb_course", schema = "catdb")
@Data
public class CourseDo {
    private String cid;
    private String cName;
    private float credit;
}
