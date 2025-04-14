package com.springbootacedamy.oderoderdetailsmapstruct.dto.request;

import com.springbootacedamy.oderoderdetailsmapstruct.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeUpdateDTO {

    private int employeeId;
    private Role employeeRole;
    private String address;
    private double salary;

}
