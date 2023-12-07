package com.api.hexagonal.application.core.domain;

import lombok.Data;

@Data
public class Address {
    private String street;
    private String city;
    private String state;
}
