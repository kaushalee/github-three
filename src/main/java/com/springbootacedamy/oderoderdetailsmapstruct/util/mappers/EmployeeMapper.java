package com.springbootacedamy.oderoderdetailsmapstruct.util.mappers;

import com.springbootacedamy.oderoderdetailsmapstruct.dto.request.EmployeeDTO;
import com.springbootacedamy.oderoderdetailsmapstruct.entity.EmployeeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeEntity staffDTOToEmployeeEntity(EmployeeDTO staffDTO);
}
