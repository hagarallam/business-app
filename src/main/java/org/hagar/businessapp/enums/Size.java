package org.hagar.businessapp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Size {
    M("M"),
    L("L"),
    XL("XL"),
    XXL("XXL"),
    XXXL("3XL");

    private String size;

}
