package com.springbootacedamy.oderoderdetailsmapstruct.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class CustomDTOUpdate {

    private int customerId;
    private String customerAddress;
    private double cusomerSalary;

}
