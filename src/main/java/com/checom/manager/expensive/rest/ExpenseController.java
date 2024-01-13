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

import com.checom.manager.expensive.models.Expense;
import com.checom.manager.expensive.services.ExpenseService;
import com.checom.manager.expensive.services.criteria.ExpenseCriteria;
import com.checom.manager.expensive.services.dto.ExpenseCreateDto;
import com.checom.manager.expensive.services.dto.StatsDto;
import com.checom.manager.expensive.utils.PageUtil;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {
    
    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<Expense> create(@RequestBody ExpenseCreateDto dto) {
        return ResponseEntity.ok( this.service.create( dto ) );
    }

    @PutMapping()
    public ResponseEntity<Expense> update(@RequestBody ExpenseCreateDto dto) {
        return ResponseEntity.ok( this.service.update( dto ) );
    }

    @GetMapping()
    public ResponseEntity<List<Expense>> findAll(ExpenseCriteria criteria, Pageable pageable) {
        Page<Expense> result = this.service.findAll(criteria, pageable);
        return ResponseEntity.ok().headers(PageUtil.generatePageHttpHeaders( result )).body(result.getContent());
    }
    
    @GetMapping("/stats")
    public ResponseEntity<StatsDto> count(ExpenseCriteria criteria) {
        return ResponseEntity.ok( this.service.getStats(criteria) );
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
