package com.checom.manager.expensive.services.statsservices;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.checom.manager.expensive.models.statsmodels.GlobalExpensesByType;
import com.checom.manager.expensive.repositories.statsrepositories.GlobalExpensesByTypeRepository;

@Service
public class GlobalExpensesByTypeService {
    private final GlobalExpensesByTypeRepository repository;

    public GlobalExpensesByTypeService(GlobalExpensesByTypeRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<GlobalExpensesByType> findAll() {
        return this.repository.findAll();
    }
}