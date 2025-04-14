package com.springbootacedamy.oderoderdetailsmapstruct.service;

import com.springbootacedamy.oderoderdetailsmapstruct.dto.request.ItemDTO;
import com.springbootacedamy.oderoderdetailsmapstruct.dto.request.ItemUpdateDTO;
import com.springbootacedamy.oderoderdetailsmapstruct.dto.response.ItemResponseDTO;

import java.util.List;

public interface ItemService {


    String saveItem(ItemDTO itemDTO);

    String updateItem(ItemUpdateDTO itemUpdateDTO);

    List<ItemResponseDTO> getAllItem();

    String deleteItemById(int itemId);

    ItemResponseDTO getItemBYId(int itemId);

    List<ItemResponseDTO> getAllItemDTOByState(boolean activeState);

    List<ItemResponseDTO> getAllItemByNameAndState(String itemName);
}
