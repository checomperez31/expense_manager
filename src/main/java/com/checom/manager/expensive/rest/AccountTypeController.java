package com.checom.manager.expensive.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.checom.manager.expensive.models.AccountType;
import com.checom.manager.expensive.services.AccountTypeService;

@RestController
@RequestMapping("/api/account-type")
public class AccountTypeController {

    private final AccountTypeService service;

    public AccountTypeController(AccountTypeService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<AccountType> create(@RequestBody AccountType entity) {
        return ResponseEntity.ok( this.service.save(entity) );
    }
    
    @PutMapping()
    public ResponseEntity<AccountType> update(@RequestBody AccountType entity) {
        return ResponseEntity.ok( this.service.save(entity) );
    }

    @GetMapping()
    public ResponseEntity<List<AccountType>> findAll() {
        return ResponseEntity.ok( this.service.findAll() );
    }
    
    @GetMapping("/active")
    public ResponseEntity<List<AccountType>> findAllActive() {
        return ResponseEntity.ok( this.service.findAllActive() );
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountType> findOne(@PathVariable Integer id) {
        return ResponseEntity.ok( this.service.findOne( id ).orElse( null ) );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        this.service.delete( id );
        return ResponseEntity.ok().build();
    }
}
