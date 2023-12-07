package com.api.hexagonal.application.ports.in;

import com.api.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {
    Customer find(String id);
}
