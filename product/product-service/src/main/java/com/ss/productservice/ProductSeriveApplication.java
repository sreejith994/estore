package com.ss.productservice;

import com.ss.productservice.config.XStreamConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableDiscoveryClient
@Import(XStreamConfig.class)
public class ProductSeriveApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductSeriveApplication.class, args);
    }

}
