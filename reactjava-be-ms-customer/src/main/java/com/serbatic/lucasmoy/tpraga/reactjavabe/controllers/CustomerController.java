package com.serbatic.lucasmoy.tpraga.reactjavabe.controllers;

import com.serbatic.lucasmoy.tpraga.reactjavabe.model.Customer;
import com.serbatic.lucasmoy.tpraga.reactjavabe.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/api/v1")
@Data
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;


    @GetMapping("/customers")
    public List<Customer> getAll() {
        return customerService.getCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable String id) {
        return customerService.getCustomerById(Long.parseLong(id));
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<String> deleteCustomerByIdl(@PathVariable String id) {
        boolean isDeleted = customerService.deleteCustomerById(Long.parseLong(id));
        if(isDeleted){
            return new ResponseEntity<>("Customer deleted successfully.", HttpStatus.OK );
        }
        return new ResponseEntity<>("Error while trying to delete customer.", HttpStatus.BAD_REQUEST );
    }

    @PostMapping("/customers")
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.save(customer);
    }
}
