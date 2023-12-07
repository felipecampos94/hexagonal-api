package com.api.hexagonal.adapters.out;

import com.api.hexagonal.adapters.out.repository.CustomerRepository;
import com.api.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.api.hexagonal.application.core.domain.Customer;
import com.api.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {
    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> find(String id) {
        var customerEntity = this.customerRepository.findById(id);
        return customerEntity.map(this.customerEntityMapper::toCustomer);
    }
}
