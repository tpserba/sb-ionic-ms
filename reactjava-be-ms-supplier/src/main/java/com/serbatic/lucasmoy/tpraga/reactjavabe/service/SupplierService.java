package com.serbatic.lucasmoy.tpraga.reactjavabe.service;


import com.serbatic.lucasmoy.tpraga.reactjavabe.model.Supplier;
import com.serbatic.lucasmoy.tpraga.reactjavabe.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public List<Supplier> getSuppliers(){
        return supplierRepository.findAll();
    }

    public Supplier getSupplierById(Long id){
        return supplierRepository.findById(id).get();
    }

    public boolean deleteSupplierById(Long id){
        try {
            supplierRepository.deleteById(id);
        } catch(Exception e){
            System.out.println("Error deleting supplier; " + e.getMessage());
            return false;
        }
        return true;
    }

    public Supplier save(Supplier supplier) {
        return  supplierRepository.save(supplier);
    }
}
