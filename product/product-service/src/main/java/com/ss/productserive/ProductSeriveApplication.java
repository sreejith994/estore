package com.ss.productserive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductSeriveApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductSeriveApplication.class, args);
    }

}
