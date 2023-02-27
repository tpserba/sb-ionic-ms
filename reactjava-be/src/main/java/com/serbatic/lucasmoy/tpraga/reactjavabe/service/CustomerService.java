package com.serbatic.lucasmoy.tpraga.reactjavabe.service;

import com.serbatic.lucasmoy.tpraga.reactjavabe.model.Customer;
import com.serbatic.lucasmoy.tpraga.reactjavabe.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id){
        return customerRepository.findById(id).get();
    }


    public boolean deleteCustomerById(Long id){
        try {
            customerRepository.deleteById(id);
        } catch(Exception e){
            System.out.println("Error deleting customer; " + e.getMessage());
            return false;
        }
         return true;
    }

    public Customer save(Customer customer) {
       return  customerRepository.save(customer);
    }
}
