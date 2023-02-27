package com.serbatic.lucasmoy.tpraga.reactjavabe.repository;

import com.serbatic.lucasmoy.tpraga.reactjavabe.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
