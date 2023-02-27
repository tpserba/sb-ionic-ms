package com.serbatic.lucasmoy.tpraga.reactjavabe.service;

import com.serbatic.lucasmoy.tpraga.reactjavabe.model.Employee;
import com.serbatic.lucasmoy.tpraga.reactjavabe.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id){
        return employeeRepository.findById(id).get();
    }
    
    public boolean deleteEmployeeById(Long id){
        try {
            employeeRepository.deleteById(id);
        } catch(Exception e){
            System.out.println("Error deleting employee; " + e.getMessage());
            return false;
        }
        return true;
    }

    public Employee save(Employee employee) {
        return  employeeRepository.save(employee);
    }
}
