package com.checom.manager.expensive.rest.statscontrollers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.checom.manager.expensive.models.statsmodels.GlobalExpensesByType;
import com.checom.manager.expensive.services.statsservices.GlobalExpensesByTypeService;

@RestController
@RequestMapping("/api/stats")
public class GlobatExpensesByTypeController {
    private final GlobalExpensesByTypeService service;

    public GlobatExpensesByTypeController(GlobalExpensesByTypeService service) {
        this.service = service;
    }

    @GetMapping("/global-types")
    public ResponseEntity<List<GlobalExpensesByType>> findAll() {
        return ResponseEntity.ok(this.service.findAll());
    }
}
