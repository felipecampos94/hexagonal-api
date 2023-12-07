package com.api.hexagonal.application.core.domain;

import lombok.Data;

@Data
public class Customer {
    private String id;
    private String name;
    private Address address;
    private String cpf;
    private Boolean isValidCpf;

    public Customer(Boolean isValidCpf) {
        this.isValidCpf = false;
    }
}
