package com.springbootacedamy.oderoderdetailsmapstruct.entity;


import com.springbootacedamy.oderoderdetailsmapstruct.entity.enums.MeasuringType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "item")

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class ItemEntity {

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column(name = "item_name", length = 100, nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name = "measuring_unit", nullable = false)
    private MeasuringType measuringType;

    @Column(name = "balance_qty", nullable = false)
    private double balanceQty;

    @Column(name = "suplly_price", nullable = false)
    private double supplyPrice;

    @Column(name = "sell_price", nullable = false)
    private double sellPrice;

    @Column(name = "active_state", columnDefinition = "TINYINT default 0 ")
    private boolean activeState;

    @OneToMany(mappedBy = "itemEntity")
    private Set<OderDetailsEntity> oderDetailsEntitySet;
}
