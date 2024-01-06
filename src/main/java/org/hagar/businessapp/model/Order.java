package org.hagar.businessapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "ORDERS")
@Getter
@Setter
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "items_count")
    private double itemsCount  ;

    @Column(name = "total_price")
    private double totalPrice ;

    @Column(name = "total_profit")
    private double totalProfit;

    @Column(name = "customer_phone")
    private String customerPhone;

    @Column(name = "creation_time")
    private Date creationTime ;


    @Column(name = "description")
    private String description ;


    public Order(double itemsCount, double totalPrice, double totalProfit, String customerPhone, Date creationTime, String description) {
        this.itemsCount = itemsCount;
        this.totalPrice = totalPrice;
        this.totalProfit = totalProfit;
        this.customerPhone = customerPhone;
        this.creationTime = creationTime;
        this.description = description;
    }
}
