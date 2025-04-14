package com.springbootacedamy.oderoderdetailsmapstruct.dto.Paginated;


import com.springbootacedamy.oderoderdetailsmapstruct.dto.response.CustomResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomPaginated {

    List<CustomResponseDTO> customResponseDTOList;
    private long dataCount;

}
