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

import com.checom.manager.expensive.models.Expense;
import com.checom.manager.expensive.services.ExpenseService;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {
    
    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<Expense> create(@RequestBody Expense entity) {
        return ResponseEntity.ok( this.service.save( entity ) );
    }

    @PutMapping()
    public ResponseEntity<Expense> update(@RequestBody Expense entity) {
        return ResponseEntity.ok( this.service.save( entity ) );
    }

    @GetMapping()
    public ResponseEntity<List<Expense>> findAll() {
        return ResponseEntity.ok( this.service.findAll() );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Expense> findOne(@PathVariable String id) {
        return ResponseEntity.ok( this.service.findOne( id ).orElse( null ) );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        this.service.delete( id );
        return ResponseEntity.ok().build();
    }
}
