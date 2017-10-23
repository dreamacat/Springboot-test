package com.cat.model.mapper;

import com.cat.model.domain.StudentDo;
import com.cat.model.dto.StudentDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2017-10-20T18:05:40+0800",
    comments = "version: 1.2.0.CR2, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
public class StudentMapperImpl implements StudentMapper {

    @Override
    public StudentDto mapToDto(StudentDo entity) {
        if ( entity == null ) {
            return null;
        }

        StudentDto studentDto = new StudentDto();

        studentDto.setName( entity.getSname() );
        studentDto.setAge( entity.getAge() );
        studentDto.setNum( entity.getSnum() );
        studentDto.setGrade( entity.getGrade() );
        studentDto.setMajor( entity.getMajor() );

        return studentDto;
    }

    @Override
    public List<StudentDto> mapToDtoList(List<StudentDo> entity) {
        if ( entity == null ) {
            return null;
        }

        List<StudentDto> list = new ArrayList<StudentDto>( entity.size() );
        for ( StudentDo studentDo : entity ) {
            list.add( mapToDto( studentDo ) );
        }

        return list;
    }
}
