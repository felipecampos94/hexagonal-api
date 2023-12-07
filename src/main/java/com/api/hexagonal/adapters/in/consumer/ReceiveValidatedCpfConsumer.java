package com.api.hexagonal.adapters.in.consumer;

import com.api.hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.api.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.api.hexagonal.application.ports.in.UpdateCustomerInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReceiveValidatedCpfConsumer {
    private final UpdateCustomerInputPort updateCustomerInputPort;
    private final CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "arantes")
    public void receive(CustomerMessage customerMessage) {
        var customer = this.customerMessageMapper.toCustomer(customerMessage);
        this.updateCustomerInputPort.update(customer, customerMessage.getZipCode());
    }
}
