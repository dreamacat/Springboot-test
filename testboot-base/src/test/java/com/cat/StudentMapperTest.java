package com.cat;

import com.cat.model.domain.StudentDo;
import com.cat.model.dto.StudentDto;
import com.cat.model.mapper.StudentMapper;
import org.junit.Test;

/**
 * Created by wangxiaoqiang on 2017/10/18.
 */
public class StudentMapperTest {
    @Test
    public void testMapper(){
        StudentDo studentDo = new StudentDo();
        studentDo.setGrade("1");
        studentDo.setMajor("it");
        studentDo.setSname("cat");
        studentDo.setSnum("1401429");

        StudentDto stu = StudentMapper.INSTANCE.mapToDto(studentDo);
        System.out.println(studentDo);
        System.out.println(stu);
    }
}
