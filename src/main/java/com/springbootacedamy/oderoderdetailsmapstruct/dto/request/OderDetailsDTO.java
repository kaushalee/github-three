package com.springbootacedamy.oderoderdetailsmapstruct.dto.request;

import com.springbootacedamy.oderoderdetailsmapstruct.entity.enums.MeasuringType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data

public class OderDetailsDTO {

    // private String itemName;
    private int qty;
    private MeasuringType measuringType;
    // private double unitDiscount;
    // private double total;
    // private int oderEntity;
    private int itemEntity;

}
