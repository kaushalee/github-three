package com.springbootacedamy.oderoderdetailsmapstruct.entity;


import com.springbootacedamy.oderoderdetailsmapstruct.entity.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

@Table(name = "employee")

public class EmployeeEntity {

    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeId;

    @Column(name = "employee_name", nullable = false, length = 50)
    private String employeeName;

    @Enumerated(EnumType.STRING)
    @Column(name = "employee_role", nullable = false)
    private Role employeeRole;

    @Column(name = "address", length = 50, nullable = false)
    private String address;

    @Column(name = "salary", nullable = false)
    private double salary;

    @Column(name = "employee_nic", nullable = false, length = 10)
    private String employeeNIC;

    @Column(name = "active_state", columnDefinition = "TINYINT default 0 ",nullable = false)
    private boolean activeState;

    @OneToMany(mappedBy = "employeeEntity")
    private Set<OderEntity> oderEntitySet;
}
