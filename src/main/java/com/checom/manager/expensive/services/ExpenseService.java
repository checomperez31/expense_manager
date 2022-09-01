package com.checom.manager.expensive.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.checom.manager.expensive.models.Expense;
import com.checom.manager.expensive.repositories.ExpenseRepository;

@Service
public class ExpenseService {

    private final ExpenseRepository repository;

    public ExpenseService(ExpenseRepository repository) {
        this.repository = repository;
    }

    @Transactional()
    public Expense save(Expense entity) {
        return this.repository.save( entity );
    }

    @Transactional(readOnly = true)
    public List<Expense> findAll() {
        return this.repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Expense> findOne(String id) {
        return this.repository.findById( id );
    }

    @Transactional
    public void delete(String id) {
        this.repository.deleteById( id );
    }
}
