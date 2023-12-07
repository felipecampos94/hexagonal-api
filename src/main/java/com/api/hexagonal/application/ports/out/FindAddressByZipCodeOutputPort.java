package com.api.hexagonal.application.ports.out;

import com.api.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {
    Address find(String zipCode);
}
