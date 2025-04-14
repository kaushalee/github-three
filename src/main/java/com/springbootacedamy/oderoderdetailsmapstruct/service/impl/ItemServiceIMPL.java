package com.springbootacedamy.oderoderdetailsmapstruct.service.impl;

import com.springbootacedamy.oderoderdetailsmapstruct.dto.request.ItemDTO;
import com.springbootacedamy.oderoderdetailsmapstruct.dto.request.ItemUpdateDTO;
import com.springbootacedamy.oderoderdetailsmapstruct.dto.response.ItemResponseDTO;
import com.springbootacedamy.oderoderdetailsmapstruct.entity.ItemEntity;
import com.springbootacedamy.oderoderdetailsmapstruct.repo.ItemRepo;
import com.springbootacedamy.oderoderdetailsmapstruct.service.ItemService;
import com.springbootacedamy.oderoderdetailsmapstruct.util.mappers.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.swagger2.mappers.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {


    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public String saveItem(ItemDTO itemDTO) {


        ItemEntity itemEntity =itemMapper.itemDTOToItemEntity(itemDTO);
        if (!itemRepo.existsById(itemEntity.getItemId())) {
            itemRepo.save(itemEntity);
            return itemDTO.getItemName() + " saved.id is - " + itemEntity.getItemId();
        } else {
            throw new RuntimeException("allready have (saveItem)"); // meka ganne kohomad?
        }
    }

    @Override
    public String updateItem(ItemUpdateDTO itemUpdateDTO) {

        if (itemRepo.existsById(itemUpdateDTO.getItemId())) {

            ItemEntity itemEntity = itemRepo.getReferenceById(itemUpdateDTO.getItemId());

            //model mapper walin giham null value kiyal anaw.
            itemEntity.setSupplyPrice(itemUpdateDTO.getSupplyPrice());
            itemEntity.setSellPrice(itemUpdateDTO.getSellPrice());

            itemRepo.save(itemEntity);
          return itemUpdateDTO.getItemName() + " is updated. " +
                  itemEntity.getItemName()  +" -> " +itemUpdateDTO.getItemName()+ " / " +
                  itemEntity.getSupplyPrice()  +" -> " +  itemUpdateDTO.getSupplyPrice()+" / " +
                  itemEntity.getSellPrice()  + " -> " +itemUpdateDTO.getSellPrice();  //?
        } else {
            throw new RuntimeException("no id found (updateItem)");
        }
    }

    @Override
    public List<ItemResponseDTO> getAllItem() {

        List<ItemEntity> itemEntityList = itemRepo.findAll();

        if (itemEntityList.size()>0) {
            List<ItemResponseDTO> itemResponseDTOList=itemMapper.itemEntityListToItemResponseDTOList(itemEntityList);

            return itemResponseDTOList;
        }else {
            throw new RuntimeException("no list found (getAllItem)");
        }
    }


    @Override
    public String deleteItemById(int itemId) {

        if (itemRepo.existsById(itemId)) {
            itemRepo.deleteById(itemId);
            return itemId + " is deleted.";
        } else {
            throw new RuntimeException("no id found (deleteItemById)");
        }
    }

    @Override
    public ItemResponseDTO getItemBYId(int itemId) {

        if (itemRepo.existsById(itemId)) {

            ItemEntity itemEntity = itemRepo.getReferenceById(itemId);
            ItemResponseDTO itemResponseDTO=itemMapper.itemEntityToItemResponseDTO(itemEntity);
            return itemResponseDTO;
        } else {
            throw new RuntimeException("no id found (getItemBYId)");
        }
    }

    @Override
    public List<ItemResponseDTO> getAllItemDTOByState(boolean activeState) {
        List<ItemEntity> itemEntityList = itemRepo.findAllByActiveStateEquals(activeState);

        if (itemEntityList.size() > 0) {
            List<ItemResponseDTO> itemResponseDTOList = itemMapper.itemEntityListToItemResponseDTOList(itemEntityList);

            return itemResponseDTOList;
        } else {
            throw new RuntimeException("no list found (getAllItemDTOByState)");
        }
    }

    @Override
    public List<ItemResponseDTO> getAllItemByNameAndState(String itemName) {
        boolean b = true;

        List<ItemEntity> itemEntityList = itemRepo.findAllByItemNameEqualsAndActiveStateEquals(itemName, b);
        if (itemEntityList.size() > 0) {
            List<ItemResponseDTO> itemResponseDTOList =itemMapper.itemEntityListToItemResponseDTOList(itemEntityList);

            return itemResponseDTOList;
        } else {
            throw new RuntimeException("no list found (getAllItemByNameAndState)");

        }
    }
}
