package com.checom.manager.expensive.services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

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
}
