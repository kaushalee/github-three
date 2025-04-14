package com.springbootacedamy.oderoderdetailsmapstruct.util.mappers;

import com.springbootacedamy.oderoderdetailsmapstruct.dto.request.CustomDTO;
import com.springbootacedamy.oderoderdetailsmapstruct.dto.response.CustomResponseDTO;
import com.springbootacedamy.oderoderdetailsmapstruct.entity.CustomEntity;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomEntity customDTOTocustomEntity(CustomDTO customDTO);

    CustomResponseDTO customEntityToCustomResponseDTO(CustomEntity customEntity);

    List<CustomResponseDTO> customEntityListToCustomResponseDTOList(List<CustomEntity> customEntityList);

    List<CustomResponseDTO> customEntityPageToCustomResponseDTOList(Page<CustomEntity> customEntityPage);


}
