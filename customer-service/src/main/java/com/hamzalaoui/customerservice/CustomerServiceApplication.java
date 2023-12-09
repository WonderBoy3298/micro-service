package com.hamzalaoui.customerservice;

import com.hamzalaoui.customerservice.entities.Customer;
import com.hamzalaoui.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner start(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.saveAll(List.of(
                    Customer.builder().name("hamza").email("hamza@alaoui.com").build(),
                    Customer.builder().name("test").email("test@gmail.com").build(),
                    Customer.builder().name("nawfal").email("nawfal@gmail.com").build()
            ));
            customerRepository.findAll().forEach(System.out::println);
        };
    }
}
