package com.cat.model.domain;

import lombok.Data;

import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by wangxiaoqiang on 2017/9/13.
 */
@Table(name = "tb_stu_course", schema = "catdb")
@Data
public class StuCourseDo {
    private String snum;
    private String cid;
    private Timestamp date;
    private String note;


}
