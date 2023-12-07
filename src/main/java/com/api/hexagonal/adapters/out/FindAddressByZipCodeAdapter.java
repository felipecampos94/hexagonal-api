package com.api.hexagonal.adapters.out;

import com.api.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.api.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.api.hexagonal.application.core.domain.Address;
import com.api.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {
    private final FindAddressByZipCodeClient findAddressByZipCodeClient;
    private final AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {
        var addressResponse = this.findAddressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(addressResponse);
    }
}
