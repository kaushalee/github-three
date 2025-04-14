package com.springbootacedamy.oderoderdetailsmapstruct.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OderOnlyResponseDTO {

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
    private int customEntity;
    private int employeeEntity;
}
