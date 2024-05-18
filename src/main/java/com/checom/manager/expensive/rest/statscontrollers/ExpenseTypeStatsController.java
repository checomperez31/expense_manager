package com.checom.manager.expensive.rest.statscontrollers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.checom.manager.expensive.models.statsmodels.ExpensesByPeriod;
import com.checom.manager.expensive.services.statsservices.ExpensesByPeriodService;

@RestController
@RequestMapping("/api/expense-type-stats")
public class ExpenseTypeStatsController {
    private final ExpensesByPeriodService service;
    
    public ExpenseTypeStatsController(ExpensesByPeriodService service) {
        this.service = service;
    }

    @GetMapping("/period/{id}")
    public ResponseEntity<List<ExpensesByPeriod>> findTypesByPeriod(@PathVariable("id") String id) {
        return ResponseEntity.ok( this.service.findAllByPeriod(id) );
    }
}
