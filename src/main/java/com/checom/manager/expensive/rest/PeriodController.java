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

import com.checom.manager.expensive.models.Period;
import com.checom.manager.expensive.services.PeriodService;
import com.checom.manager.expensive.services.dto.PeriodCreateDto;
import com.checom.manager.expensive.services.dto.PeriodDto;
import com.checom.manager.expensive.services.dto.PeriodWithExpensesDto;

@RestController
@RequestMapping("/api/period")
public class PeriodController {
    
    private final PeriodService service;

    public PeriodController(PeriodService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<Period> create(@RequestBody PeriodCreateDto entity) {
        return ResponseEntity.ok( this.service.save( entity ) );
    }
    
    @PutMapping
    public ResponseEntity<Period> update(@RequestBody PeriodCreateDto entity) {
        return ResponseEntity.ok( this.service.save( entity ) );
    }

    @GetMapping
    public ResponseEntity<List<Period>> findAll() {
        return ResponseEntity.ok( this.service.findAll() );
    }
    
    @GetMapping("/active")
    public ResponseEntity<List<Period>> findAllActive() {
        return ResponseEntity.ok( this.service.findAll() );
    }
    
    @GetMapping("/active-dashboard")
    public ResponseEntity<List<PeriodDto>> findAllActiveDto() {
        return ResponseEntity.ok( this.service.findAllDto() );
    }
    
    @GetMapping("/active-expenses")
    public ResponseEntity<List<PeriodWithExpensesDto>> findAllActiveWithExpensesDto() {
        return ResponseEntity.ok( this.service.findAllDtoWithExpenses() );
    }

    @GetMapping("/last")
    public ResponseEntity<PeriodDto> findLast() {
        return ResponseEntity.ok( this.service.findLast().orElse( null ) );
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PeriodDto> findOne(@PathVariable String id) {
        return ResponseEntity.ok( this.service.findOne( id ).orElse( null ) );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        this.service.delete( id );
        return ResponseEntity.ok().build();
    }
}
