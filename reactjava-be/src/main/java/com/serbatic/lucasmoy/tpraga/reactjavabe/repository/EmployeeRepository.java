package com.serbatic.lucasmoy.tpraga.reactjavabe.repository;

import com.serbatic.lucasmoy.tpraga.reactjavabe.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
