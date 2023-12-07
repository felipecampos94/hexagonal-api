package com.api.hexagonal.application.core.usecase;

import com.api.hexagonal.application.core.domain.Customer;
import com.api.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.api.hexagonal.application.ports.out.FindCustomerByIdOutputPort;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {
    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

    public FindCustomerByIdUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort) {
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
    }

    @Override
    public Customer find(String id) {
        return this.findCustomerByIdOutputPort.find(id)
                .orElseThrow(() -> new RuntimeException("Customer Not Found!"));
    }
}