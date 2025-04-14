package com.springbootacedamy.oderoderdetailsmapstruct.dto.Paginated;


import com.springbootacedamy.oderoderdetailsmapstruct.dto.response.OderResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OderPaginated {

    List<OderResponseDTO> oderResponseDTOList;
    long DataCount;
}
