package com.checom.manager.expensive.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.checom.manager.expensive.models.Period;
import com.checom.manager.expensive.repositories.PeriodRepository;
import com.checom.manager.expensive.services.dto.PeriodCreateDto;
import com.checom.manager.expensive.services.mapping.PeriodCreateMapper;

@Service
public class PeriodService {
    private final PeriodRepository repository;
    private final PeriodCreateMapper createMapper;

    public PeriodService(PeriodRepository repository, PeriodCreateMapper createMapper) {
        this.repository = repository;
        this.createMapper = createMapper;
    }

    @Transactional
    public Period save(PeriodCreateDto dto) {
        return this.repository.save( this.createMapper.toEntity( dto ) );
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
