package com.api.hexagonal.application.ports.out;

import com.api.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {
    void update(Customer customer);
}
