package com.cloudymicroservices.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public record CustomerController(CustomerService customerService) {

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest){
        log.info("created new customer" + customerRegistrationRequest.toString());
        customerService.registerCustomer(customerRegistrationRequest);
    }

    @GetMapping
    public List<Customer> getCustomer(){
        return customerService.getCustomers();
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        log.info("deleted customer");
        customerService.deleteCustomerById(id);
    }

    // todo: add response code information
}
