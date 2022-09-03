package com.checom.manager.expensive.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.checom.manager.expensive.models.Period;
import com.checom.manager.expensive.repositories.PeriodRepository;

@Service
public class PeriodService {
    private final PeriodRepository repository;

    public PeriodService(PeriodRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Period save(Period entity) {
        return this.repository.save( entity );
    }

    @Transactional(readOnly = true)
    public List<Period> findAll() {
        return this.repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Period> findOne(String id) {
        return this.repository.findById( id );
    }

    @Transactional
    public void delete(String id) {
        this.repository.deleteById( id );
    }
}
