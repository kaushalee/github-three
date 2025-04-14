package com.springbootacedamy.oderoderdetailsmapstruct.dto.Paginated;


import com.springbootacedamy.oderoderdetailsmapstruct.dto.response.OderOnlyResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OderOnlyPaginated {

    List<OderOnlyResponseDTO> oderOnlyResponseDTOList;
    long dataCount;

}
