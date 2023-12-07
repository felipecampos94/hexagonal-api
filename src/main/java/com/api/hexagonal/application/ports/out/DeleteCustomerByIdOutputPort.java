package com.api.hexagonal.application.ports.out;

public interface DeleteCustomerByIdOutputPort {
    void delete(String id);
}
