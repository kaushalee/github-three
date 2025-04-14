package com.springbootacedamy.oderoderdetailsmapstruct.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "customer")

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class CustomEntity {


    @Id
    @Column(name ="customer_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@GeneratedValue(strategy =  GenerationType.AUTO)
    private int customerId;

    @Column(name ="cutomer_name",length = 100)
    private String customerName;

    @Column(name = "customer_address",length = 200)
    private String customerAddress;

    @Column(name = "customer_nic",length = 10,nullable = false)
    private String customerNIC; //lengtheka 10 adu or wadi unath error ekak anne nane ?

    @Column(name = "customer_salary")
    private double cusomerSalary;

    // @Type(type="jeson")
    //  @Column(name = "contact numbers",length =10 ,columnDefinition = "jeson")
    // private ArrayList contactNo;

    @Column(name = "active_state",columnDefinition = "TINYINT default 1 ")
    private boolean activeState;

    @OneToMany(mappedBy = "customEntity")
    private Set<OderEntity> oderEntities;




}
