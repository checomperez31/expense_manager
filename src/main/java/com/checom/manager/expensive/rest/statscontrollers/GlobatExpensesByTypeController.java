package com.checom.manager.expensive.rest.statscontrollers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.checom.manager.expensive.models.statsmodels.GastosExtended;
import com.checom.manager.expensive.models.statsmodels.GlobalExpensesByType;
import com.checom.manager.expensive.services.statsservices.GastosExtendedService;
import com.checom.manager.expensive.services.statsservices.GlobalExpensesByTypeService;

@RestController
@RequestMapping("/api/stats")
public class GlobatExpensesByTypeController {
    private final GlobalExpensesByTypeService service;
    private final GastosExtendedService gastosExtendedService;

    public GlobatExpensesByTypeController(GlobalExpensesByTypeService service, GastosExtendedService gastosExtendedService) {
        this.service = service;
        this.gastosExtendedService = gastosExtendedService;
    }

    @GetMapping("/types/global")
    public ResponseEntity<List<GlobalExpensesByType>> findTypesGlobal() {
        return ResponseEntity.ok(this.service.findAll());
    }

    @GetMapping("/types/period/{id}")
    public ResponseEntity<List<GastosExtended>> findTypesByPeriod(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.gastosExtendedService.findTypesByPeriod( id ));
    }
}
