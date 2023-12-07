package com.api.hexagonal.application.ports.out;

import com.api.hexagonal.application.core.domain.Customer;

public interface InsertCustomerOutputPort {
    void insert(Customer customer);
}
