package com.springbootacedamy.oderoderdetailsmapstruct.util.mappers;

import com.springbootacedamy.oderoderdetailsmapstruct.dto.request.ItemDTO;
import com.springbootacedamy.oderoderdetailsmapstruct.dto.response.ItemResponseDTO;
import com.springbootacedamy.oderoderdetailsmapstruct.entity.ItemEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    ItemEntity itemDTOToItemEntity(ItemDTO itemDTO);

    List<ItemResponseDTO> itemEntityListToItemResponseDTOList(List<ItemEntity> itemEntityList);

    ItemResponseDTO itemEntityToItemResponseDTO(ItemEntity itemEntity);
}
