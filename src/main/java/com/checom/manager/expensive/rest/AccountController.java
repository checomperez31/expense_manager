package com.checom.manager.expensive.rest;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.checom.manager.expensive.models.Account;
import com.checom.manager.expensive.services.AccountService;
import com.checom.manager.expensive.utils.PageUtil;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    
    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<Account> create(@RequestBody Account entity) {
        return ResponseEntity.ok( this.service.save( entity ) );
    }

    @PutMapping()
    public ResponseEntity<Account> update(@RequestBody Account entity) {
        return ResponseEntity.ok( this.service.save( entity ) );
    }

    @GetMapping()
    public ResponseEntity<List<Account>> findAll(Pageable pageable) {
        Page<Account> page = this.service.findAll( pageable );
        return ResponseEntity.ok()
            .headers(PageUtil.generatePageHttpHeaders( page ))
            .body(page.getContent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> findOne(@PathVariable String id) {
        return ResponseEntity.ok( this.service.findOne( id ).orElse( null ) );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        this.service.delete( id );
        return ResponseEntity.ok().build();
    }
}