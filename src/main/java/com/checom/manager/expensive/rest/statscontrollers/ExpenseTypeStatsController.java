package com.checom.manager.expensive.rest.statscontrollers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.checom.manager.expensive.models.statsmodels.GastosExtended;
import com.checom.manager.expensive.services.statsservices.GastosExtendedService;

@RestController
@RequestMapping("/api/expense-type-stats")
public class ExpenseTypeStatsController {
    private final GastosExtendedService service;
    
    public ExpenseTypeStatsController(GastosExtendedService service) {
        this.service = service;
    }

    @GetMapping("/period/{id}")
    public ResponseEntity<List<GastosExtended>> findTypesByPeriod(@PathVariable("id") String id) {
        return ResponseEntity.ok( this.service.findTypesByPeriod(id) );
    }
}
