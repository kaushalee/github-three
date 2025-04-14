package com.springbootacedamy.oderoderdetailsmapstruct.service;

import com.springbootacedamy.oderoderdetailsmapstruct.dto.request.OderDTO;
import com.springbootacedamy.oderoderdetailsmapstruct.dto.response.OderDetailsResponseDTO;
import com.springbootacedamy.oderoderdetailsmapstruct.dto.response.OderOnlyResponseDTO;
import com.springbootacedamy.oderoderdetailsmapstruct.dto.response.OderResponseDTO;

import java.util.List;

public interface OderService {
    String saveOder(OderDTO oderDTO);

   // String saveOderWithMapper(OderDTO oderDTO);

    OderResponseDTO searchOder(int oderId);

    String cancelOder(int oderId);

    


    List<OderOnlyResponseDTO> getOderByCustomer(int customerId);

    List<OderDetailsResponseDTO> getOderDetailsByItem(int itemId);

    List<OderOnlyResponseDTO> getoderBystate(boolean activeState);
}
