package com.lam.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressWithName extends Address {

    private String firstname;
    private String lastname;

    public AddressWithName(String firstname, String lastname) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
    }

    /**
     * 添加一个私有方法，使得子类无法调用，用于测试 instanceof
     * */
    public void methodForAddressWithName() {
        System.out.println("Methode from address private.");
    }
}
