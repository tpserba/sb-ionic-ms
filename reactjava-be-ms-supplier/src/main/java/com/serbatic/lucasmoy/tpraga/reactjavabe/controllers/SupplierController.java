package com.serbatic.lucasmoy.tpraga.reactjavabe.controllers;

import com.serbatic.lucasmoy.tpraga.reactjavabe.model.Supplier;
import com.serbatic.lucasmoy.tpraga.reactjavabe.service.SupplierService;
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
public class SupplierController {



    private final SupplierService supplierService;

    @GetMapping("/suppliers")
    public List<Supplier> getAll() {
        return supplierService.getSuppliers();
    }
    @GetMapping("/suppliers/{id}")
    public Supplier getSupplierById(@PathVariable String id) {
        return supplierService.getSupplierById(Long.parseLong(id));
    }
    @DeleteMapping("/suppliers/{id}")
    public ResponseEntity<String> deleteSupplierById(@PathVariable String id) {
        boolean isDeleted = supplierService.deleteSupplierById(Long.parseLong(id));
        if(isDeleted){
            return new ResponseEntity<>("Supplier deleted successfully.", HttpStatus.OK );
        }
        return new ResponseEntity<>("Error while trying to delete supplier.", HttpStatus.BAD_REQUEST );
    }
    @PostMapping("/suppliers")
    public Supplier saveSupplier(@RequestBody Supplier supplier) {
        return supplierService.save(supplier);
    }
}
