package com.lam.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class PostalCode {

    private String postalCode;
    private int postalCodeLength;

    public boolean isValid() {
        return postalCode.length() == postalCodeLength;
    }

}
