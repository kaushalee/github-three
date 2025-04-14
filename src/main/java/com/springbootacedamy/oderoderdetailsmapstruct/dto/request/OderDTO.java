package com.springbootacedamy.oderoderdetailsmapstruct.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OderDTO {

    // private String customName;
    private Date date;
    //  private double netTotal;
    //  private double totalDiscount;
    private double cash;
    //  private double balance;
    //private String cashier;
    //  private int noOfItem;
    private int customEntity;
    private List<OderDetailsDTO> oderDetailsDTOList;
    private int employeeEntity;


}
