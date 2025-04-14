package com.springbootacedamy.oderoderdetailsmapstruct.entity;

import com.springbootacedamy.oderoderdetailsmapstruct.entity.enums.MeasuringType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "oder_details")
public class OderDetailsEntity {

    @Id
    @Column(name = "details_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int detailId;

    @Column(name = "item_name", nullable = false,length = 20)
    private String itemName;

    @Column(name = "qty", nullable = false)
    private int qty;

    @Enumerated(EnumType.STRING)
    @Column(name = "measuring_type", nullable = false)
    private MeasuringType measuringType;

    @Column(name = "unit_discount", nullable = false)
    private double unitDiscount;

    @Column(name = "total", nullable = false)
    private double total;

    @ManyToOne
    @JoinColumn(name = "oder_id",nullable = false)
    private OderEntity oderEntity;

    @ManyToOne
    @JoinColumn(name = "item_id",nullable = false)
    private ItemEntity itemEntity;

    public OderDetailsEntity(String itemName, int qty, MeasuringType measuringType, double unitDiscount, double total, OderEntity oderEntity, ItemEntity itemEntity) {
        this.itemName = itemName;
        this.qty = qty;
        this.measuringType = measuringType;
        this.unitDiscount = unitDiscount;
        this.total = total;
        this.oderEntity = oderEntity;
        this.itemEntity = itemEntity;
    }

    //model mapper
    public OderDetailsEntity(int qty, MeasuringType measuringType) {
        this.qty = qty;
        this.measuringType = measuringType;
    }


}
