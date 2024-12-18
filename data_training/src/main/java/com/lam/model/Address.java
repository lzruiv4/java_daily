package com.lam.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Address {

    private String street;
    private int houseNumber;
    private PostalCode postalCode;
    private String city;

    public static class Builder {

        private String street;
        private int houseNumber;
        private PostalCode postalCode;
        private String city;

        public Builder addStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder addHouseNumber(int houseNumber) {
            this.houseNumber = houseNumber;
            return this;
        }

        public Builder addPostalCode(PostalCode postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder addCity(String city) {
            this.city = city;
            return this;
        }

        public Address build() {
            return new Address(street, houseNumber, postalCode, city);
        }
    }
}
