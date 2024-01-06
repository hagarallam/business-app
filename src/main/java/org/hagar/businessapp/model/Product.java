package org.hagar.businessapp.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hagar.businessapp.enums.Colors;
import org.hagar.businessapp.enums.ProductsType;
import org.hagar.businessapp.enums.Size;

import java.math.BigDecimal;

@Entity
@Table(name = "PRODUCTS")
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "product_type")
    @Enumerated(EnumType.STRING)
    private ProductsType productType ;

    @Column(name = "color")
    @Enumerated(EnumType.STRING)
    private Colors color ;

    @Column(name = "size")
    @Enumerated(EnumType.STRING)
    private Size size;


    @Column(name = "buying_price")
    private BigDecimal buyingPrice ;

    @Column(name = "selling_price")
    private BigDecimal sellingPrice;


    @Column(name = "description")
    private String description ;

    public Product(ProductsType productType, Colors color, Size size, BigDecimal buyingPrice, BigDecimal sellingPrice, String description) {
        this.productType = productType;
        this.color = color;
        this.size = size;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.description = description;
    }
}
