package com.example.vendor.controller;
import com.example.vendor.repository.VendorRepository;

import com.example.vendor.model.Vendor;
import com.example.vendor.service.VendorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendors")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,
RequestMethod.DELETE, RequestMethod.OPTIONS})
public class VendorController {

    private final VendorService vendorService;
    private final VendorRepository vendorRepository;


    @Autowired
    public VendorController(VendorService vendorService, VendorRepository vendorRepository) {
        this.vendorService = vendorService;
        this.vendorRepository = vendorRepository;
    }

    @GetMapping
    public ResponseEntity<List<Vendor>> getAllVendors() {
        return ResponseEntity.ok(vendorService.getAllVendors());
    }

    @PostMapping
    public ResponseEntity<?> createVendor(@Valid @RequestBody Vendor vendor) {
        try {
            Vendor createdVendor = vendorService.createVendor(vendor);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVendor);
        } catch (com.example.vendor.exception.DuplicateEmailException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
public ResponseEntity<Void> deleteVendor(@PathVariable Long id) {
    vendorRepository.deleteById(id);
    return ResponseEntity.noContent().build();
}

}