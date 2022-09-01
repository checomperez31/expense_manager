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

import com.checom.manager.expensive.models.ExpenseType;
import com.checom.manager.expensive.services.ExpenseTypeService;

@RestController
@RequestMapping("/api/expense-type")
public class ExpenseTypeController {

    private final ExpenseTypeService service;

    public ExpenseTypeController(ExpenseTypeService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<ExpenseType> create(@RequestBody ExpenseType entity) {
        return ResponseEntity.ok( this.service.save(entity) );
    }
    
    @PutMapping
    public ResponseEntity<ExpenseType> update(@RequestBody ExpenseType entity) {
        return ResponseEntity.ok( this.service.save(entity) );
    }

    @GetMapping()
    public ResponseEntity<List<ExpenseType>> findAll() {
        return ResponseEntity.ok( this.service.findAll() );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseType> findOne(@PathVariable Integer id) {
        return ResponseEntity.ok( this.service.findOne( id ).orElse( null ) );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        this.service.delete( id );
        return ResponseEntity.ok().build();
    }
}
