package com.api.hexagonal.adapters.out;

import com.api.hexagonal.adapters.out.repository.CustomerRepository;
import com.api.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.api.hexagonal.application.core.domain.Customer;
import com.api.hexagonal.application.ports.out.InsertCustomerOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InsertCustomerAdapter implements InsertCustomerOutputPort {
    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    @Override
    public void insert(Customer customer) {
        var customerEntity = this.customerEntityMapper.toCustomerEntity(customer);
        this.customerRepository.save(customerEntity);
    }
}
