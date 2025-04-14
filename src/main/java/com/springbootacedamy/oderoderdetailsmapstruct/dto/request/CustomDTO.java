package com.springbootacedamy.oderoderdetailsmapstruct.dto.request;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class CustomDTO {

    private String customerName;
    private String customerAddress;
    private String customerNIC;
    private double cusomerSalary;
    // private ArrayList contactNo;

}
