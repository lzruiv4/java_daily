package com.lam.designPattern.builder.address;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    private List<Address> address = new ArrayList<>();

    @BeforeEach
    void setUp() {
        Address address1 = new Address
                .Builder()
                .addStreet("A Street")
                .addHouseNumber(123)
                .addPostalCode(new PostalCode("12345", 5))
                .addCity("Bonn")
                .build();
        this.address.add(address1);
    }

    @Test
    void testAddressInList() {
        assertEquals(1, address.size());
        Address addressInList = address.get(0);
        assertEquals("A Street", addressInList.getStreet());
        assertEquals(123, addressInList.getHouseNumber());
        assertEquals("12345", addressInList.getPostalCode().getPostalCode());
        assertEquals(5, addressInList.getPostalCode().getPostalCodeLength());
        assertTrue(addressInList.getPostalCode().isValid());
        assertEquals("Bonn", addressInList.getCity());
    }

}