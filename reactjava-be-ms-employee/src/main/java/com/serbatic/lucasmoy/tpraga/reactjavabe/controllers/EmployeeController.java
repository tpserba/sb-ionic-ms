package com.serbatic.lucasmoy.tpraga.reactjavabe.controllers;

import com.serbatic.lucasmoy.tpraga.reactjavabe.model.Employee;
import com.serbatic.lucasmoy.tpraga.reactjavabe.service.EmployeeService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Data
@RequiredArgsConstructor
public class EmployeeController {


    private final EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAll() {
        return employeeService.getEmployees();
    }
    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable String id) {
        return employeeService.getEmployeeById(Long.parseLong(id));
    }
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable String id) {
        boolean isDeleted = employeeService.deleteEmployeeById(Long.parseLong(id));
        if(isDeleted){
            return new ResponseEntity<>("Employee deleted successfully.", HttpStatus.OK );
        }
        return new ResponseEntity<>("Error while trying to delete employee.", HttpStatus.BAD_REQUEST );
    }
    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }
}
