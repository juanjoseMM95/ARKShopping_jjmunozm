package com.jjmunozm.course.springboot.webapp.springboot_web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jjmunozm.course.springboot.webapp.springboot_web.model.Supplier;
import com.jjmunozm.course.springboot.webapp.springboot_web.repository.SupplierRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SupplierService {
    private final SupplierRepository supplierRepository;

    public List<Supplier> allSuppliers(){
        return supplierRepository.findAll();
    }

    public Supplier newSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public Supplier getSupplier(int id) {
        return supplierRepository.findById(id).orElse(null);
    }

    public Supplier updateSupplier(int id, Supplier supplier) {
        Optional<Supplier> supplierExist = supplierRepository.findById(id);
        if (supplierExist.isPresent()) {
            supplier.setId(id);
            return supplierRepository.save(supplier);
        }
        return null;
    }

    public boolean deleteSupplier(int id) {
        Optional<Supplier> supplierExist = supplierRepository.findById(id);
        if (supplierExist.isPresent()) {
            supplierRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
