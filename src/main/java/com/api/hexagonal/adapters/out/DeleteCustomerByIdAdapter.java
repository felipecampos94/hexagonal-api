package com.api.hexagonal.adapters.out;

import com.api.hexagonal.adapters.out.repository.CustomerRepository;
import com.api.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOutputPort {
    private final CustomerRepository customerRepository;

    @Override
    public void delete(String id) {
        this.customerRepository.deleteById(id);
    }
}
