package com.cat.model.mapper;

import com.cat.model.domain.StudentDo;
import com.cat.model.dto.StudentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Created by wangxiaoqiang on 2017/10/18.
 */
@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mappings({
            @Mapping(source = "entity.snum", target = "num"),
            @Mapping(source = "entity.sname", target = "name"),
            @Mapping(target = "age", expression = "java (com.cat.model.dto.StudentDto.formatAge(entity.age))"),
    })
    StudentDto mapToDto(StudentDo entity);

    List<StudentDto> mapToDtoList(List<StudentDo> entity);


//    @Mappings({
//            @Mapping(source = "entity.installmentYuan", target = "installment"),
//            @Mapping(source = "entity.installmentYuan", target = "installmentStr"),
//            @Mapping(source = "entity.prepaidAmountYuan", target = "prepaidAmount"),
//            @Mapping(source = "entity.prepaidAmountWan", target = "prepaidAmountStr"),
//            @Mapping(source = "entity.finalPaymentYuan", target = "finalPayment"),
//            @Mapping(source = "entity.allFinalPaymentYuan", target = "allFinalPayment"),
//    })
//    FinanceInfoForH5VO mapToH5(FinanceInfoDto entity);
//
//    /**
//     *
//     * @param entity
//     * @return
//     */
//
//    AppointmentVO mapToAppoint(FinanceInfoDto entity);
//
//    /**
//     * 将金融方案列表转换为前端h5使用的数据结构
//     * @param financeInfoList 原金融方案列表
//     * @return FinanceInfoForH5VO
//     */
//    List<FinanceInfoForH5VO> mapToList(List<FinanceInfoDto> financeInfoList);
}
