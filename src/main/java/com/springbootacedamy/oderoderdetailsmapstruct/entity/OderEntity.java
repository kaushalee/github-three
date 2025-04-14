package com.springbootacedamy.oderoderdetailsmapstruct.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "oders")
public class OderEntity {

    @Id
    @Column(name = "oder_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int oderId;

    @Column(name = "custom_name", nullable = false,length = 20)
    private String customName;

    @Column(name = "date", nullable = false, columnDefinition = "DATETIME")
    private Date date;

    //  @Column(name = "time", nullable = false, columnDefinition = "DATETIME")
    //  private Timer timer;

    @Column(name = "net_total", nullable = false)
    private double netTotal;

    @Column(name = "total_discount", nullable = false)
    private double totalDiscount;

    @Column(name = "cash", nullable = false)
    private double cash;

    @Column(name = "balance", nullable = false)
    private double balance;

    @Column(name = "cashier", nullable = false, length = 20)
    private String cashier;

    @Column(name = "no_of_item", nullable = false)
    private int noOfItem;

    @Column(name = "active_state", columnDefinition = "TINYINT default 1 ")
    private boolean activeState;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomEntity customEntity;

    @OneToMany(mappedBy = "oderEntity")
    private Set<OderDetailsEntity> oderDetailsEntitySet;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private EmployeeEntity employeeEntity;


    public OderEntity(String customName, Date date, double cash, String cashier, CustomEntity customEntity, EmployeeEntity employeeEntity) {
        this.customName = customName;
        this.date = date;
        this.cash = cash;
        this.cashier = cashier;
        this.customEntity = customEntity;
        this.employeeEntity = employeeEntity;
    }

    //for mapper
    public OderEntity(Date date, double cash) {
        this.date = date;
        this.cash = cash;
    }



}
