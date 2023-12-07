package com.api.hexagonal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HexagonalApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HexagonalApiApplication.class, args);
    }

}
