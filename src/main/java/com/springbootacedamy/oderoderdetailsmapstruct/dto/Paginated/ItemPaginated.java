package com.springbootacedamy.oderoderdetailsmapstruct.dto.Paginated;



import com.springbootacedamy.oderoderdetailsmapstruct.dto.response.ItemResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemPaginated {

    List<ItemResponseDTO>  itemResponseDTOList;
    ;private  long dataCount;
}
