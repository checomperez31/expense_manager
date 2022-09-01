package com.checom.manager.expensive.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.checom.manager.expensive.models.ExpenseType;
import com.checom.manager.expensive.repositories.ExpenseTypeRepository;

@Service
public class ExpenseTypeService {
    
    private final ExpenseTypeRepository repository;

    public ExpenseTypeService(ExpenseTypeRepository repository) {
        this.repository = repository;
    }

    @Transactional()
    public ExpenseType save(ExpenseType entity) {
        return this.repository.save( entity );
    }

    @Transactional(readOnly = true)
    public List<ExpenseType> findAll() {
        return this.repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<ExpenseType> findOne(Integer id) {
        return this.repository.findById( id );
    }

    @Transactional()
    public void delete(Integer id) {
        this.repository.deleteById( id );
    }
}
