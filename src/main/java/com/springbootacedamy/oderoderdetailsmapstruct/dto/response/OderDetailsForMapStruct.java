package com.springbootacedamy.oderoderdetailsmapstruct.dto.response;

import com.springbootacedamy.oderoderdetailsmapstruct.entity.enums.MeasuringType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OderDetailsForMapStruct {
    private int detailId;
    private String itemName;
    private int qty;
    private MeasuringType measuringType;
    private double unitDiscount;
    private double total;
}
