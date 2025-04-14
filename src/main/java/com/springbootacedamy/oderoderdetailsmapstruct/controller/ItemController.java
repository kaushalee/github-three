package com.springbootacedamy.oderoderdetailsmapstruct.controller;

import com.springbootacedamy.oderoderdetailsmapstruct.dto.request.ItemDTO;
import com.springbootacedamy.oderoderdetailsmapstruct.dto.request.ItemUpdateDTO;
import com.springbootacedamy.oderoderdetailsmapstruct.dto.response.ItemResponseDTO;
import com.springbootacedamy.oderoderdetailsmapstruct.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/save-item")
    public String saveItem(@RequestBody ItemDTO itemDTO){

        String text=itemService.saveItem(itemDTO);
        return text;
    }



    @PutMapping("/updtae-item")
    public String updateItem(@RequestBody ItemUpdateDTO itemUpdateDTO){

        String text= itemService.updateItem(itemUpdateDTO);
        return text;

    }


    @GetMapping("/get-all-item")
    public List<ItemResponseDTO> getAllItem(){

        List<ItemResponseDTO> itemResponseDTOList=itemService.getAllItem();
        return itemResponseDTOList;
    }


    @DeleteMapping(path = "/delete-item-by-id" ,params = "id")
    public String deleteItemById(@RequestParam(value = "id") int itemId){

        String text= itemService.deleteItemById(itemId);

        return text;
    }


    @GetMapping(path = "/get-item-by-id",params = "id")
    public ItemResponseDTO getItemById(@RequestParam (value = "id") int itemId){
        ItemResponseDTO itemResponseDTO=itemService.getItemBYId(itemId);

        return itemResponseDTO;
    }



    @GetMapping(path = "/get-all-item-by-active state",params = "state")
    public List<ItemResponseDTO> getAllItemDTOByState(@RequestParam(value = "state") boolean activeState){

        List<ItemResponseDTO> itemResponseDTOList =itemService.getAllItemDTOByState(activeState);

        return itemResponseDTOList;
    }


    @GetMapping(path = "/get-all-item -by-name-and-state" ,params = "itemName")
    public List<ItemResponseDTO> getAllItemByNameAndState(@RequestParam(value = "itemName") String itemName){

        List<ItemResponseDTO> itemResponseDTOList =itemService.getAllItemByNameAndState(itemName);
        return itemResponseDTOList;


    }

}
