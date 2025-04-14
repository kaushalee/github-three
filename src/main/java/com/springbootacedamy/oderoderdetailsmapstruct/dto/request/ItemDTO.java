package com.springbootacedamy.oderoderdetailsmapstruct.dto.request;

import com.springbootacedamy.oderoderdetailsmapstruct.entity.enums.MeasuringType;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class ItemDTO {

    private String itemName;
    private MeasuringType measuringType;
    private double balanceQty;
    private double supplyPrice;
    private double sellPrice;


}
