package com.springbootacedamy.oderoderdetailsmapstruct.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OderForMapStruct {

    private int oderId;
    private String customName;
    private Date date;
    //  private Timer timer;
    private double netTotal;
    private double totalDiscount;
    private double cash;
    private double balance;
    private String cashier;
    private int noOfItem;
    private boolean activeState;





}
