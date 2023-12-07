package com.api.hexagonal.adapters.out;

import com.api.hexagonal.adapters.out.repository.CustomerRepository;
import com.api.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.api.hexagonal.application.core.domain.Customer;
import com.api.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {
    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    @Override
    public void update(Customer customer) {
        var customerEntity = this.customerEntityMapper.toCustomerEntity(customer);
        this.customerRepository.save(customerEntity);
    }
}
