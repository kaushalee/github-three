package com.springbootacedamy.oderoderdetailsmapstruct.dto.request;

import com.springbootacedamy.oderoderdetailsmapstruct.entity.enums.MeasuringType;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class ItemUpdateDTO {

    private int itemId;
    private String itemName;
    private MeasuringType measuringType;
    private double supplyPrice;
    private double sellPrice;

}
