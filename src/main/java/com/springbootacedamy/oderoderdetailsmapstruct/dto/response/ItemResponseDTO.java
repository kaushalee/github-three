package com.springbootacedamy.oderoderdetailsmapstruct.dto.response;

import com.springbootacedamy.oderoderdetailsmapstruct.entity.enums.MeasuringType;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class ItemResponseDTO {

    private int itemId;
    private String itemName;
    private MeasuringType measuringType;
    private double balanceQty;
    private double supplyPrice;
    private double sellPrice;
    private boolean activeState;


}
