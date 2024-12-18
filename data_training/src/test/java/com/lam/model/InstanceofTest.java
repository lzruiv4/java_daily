package com.lam.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InstanceofTest {

    Address addressObject;

    @BeforeEach
    void setUp() {
        addressObject = new AddressWithName("first", "last");
    }

    @Test
    void testInstanceof() {
        if(addressObject instanceof AddressWithName address) {
            // Since JDK 14
            address.methodForAddressWithName();
            // Or
            ((AddressWithName) addressObject).methodForAddressWithName();
        }
    }
}