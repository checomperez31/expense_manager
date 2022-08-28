package com.checom.manager.expensive.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping()
    public ResponseEntity<List<AccountType>> findAll() {
        return ResponseEntity.ok( this.service.findAll() );
    }
}
