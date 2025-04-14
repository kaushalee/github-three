package com.springbootacedamy.oderoderdetailsmapstruct.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class CustomResponseDTO {

    private int customerId;
    private String customerName;
    private String customerAddress;
    private String customerNIC;
    private double cusomerSalary;
    // private ArrayList contactNo;
    private boolean activeState;


}
