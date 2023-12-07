package com.api.hexagonal.adapters.in.controller;

import com.api.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.api.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.api.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.api.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.api.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.api.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.api.hexagonal.application.ports.in.UpdateCustomerInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final InsertCustomerInputPort insertCustomerInputPort;
    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final UpdateCustomerInputPort updateCustomerInputPort;
    private final DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;
    private final CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {
        var customer = this.customerMapper.toCustomer(customerRequest);
        this.insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable("id") final String id) {
        var customer = this.findCustomerByIdInputPort.find(id);
        var customerResponse = this.customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") String id, @Valid @RequestBody CustomerRequest customerRequest) {
        var customer = this.customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        this.updateCustomerInputPort.update(customer, customerRequest.getZipCode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        this.deleteCustomerByIdInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }
}
