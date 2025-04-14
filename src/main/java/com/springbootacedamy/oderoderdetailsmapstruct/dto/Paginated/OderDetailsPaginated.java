package com.springbootacedamy.oderoderdetailsmapstruct.dto.Paginated;

import com.springbootacedamy.oderoderdetailsmapstruct.dto.response.OderDetailsResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OderDetailsPaginated {

    List<OderDetailsResponseDTO> oderDetailsResponseDTOList;
    long dataCount;

}
