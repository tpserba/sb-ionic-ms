package com.serbatic.lucasmoy.tpraga.reactjavabe.repository;

import com.serbatic.lucasmoy.tpraga.reactjavabe.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
