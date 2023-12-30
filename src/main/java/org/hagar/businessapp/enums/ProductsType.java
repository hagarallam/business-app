package org.hagar.businessapp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductsType {
    HOODIE("HOODIE"),
    SWEAT_PANTS("SWEAT_PANTS");

    private String productType;
}
