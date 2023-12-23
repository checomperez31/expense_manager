package com.checom.manager.expensive.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.checom.manager.expensive.models.Period;
import com.checom.manager.expensive.repositories.PeriodRepository;
import com.checom.manager.expensive.services.dto.PeriodCreateDto;
import com.checom.manager.expensive.services.dto.PeriodDto;
import com.checom.manager.expensive.services.mapping.PeriodCreateMapper;
import com.checom.manager.expensive.services.mapping.PeriodMapper;

@Service
public class PeriodService {
    private final PeriodRepository repository;
    private final PeriodCreateMapper createMapper;
    private final PeriodMapper mapper;

    public PeriodService(PeriodRepository repository, PeriodCreateMapper createMapper, PeriodMapper mapper) {
        this.repository = repository;
        this.createMapper = createMapper;
        this.mapper = mapper;
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
    public List<PeriodDto> findAllDto() {
        return this.mapper.toDto(this.repository.findAll());
    }

    @Transactional(readOnly = true)
    public Optional<Period> findOne(String id) {
        return this.repository.findById( id );
    }
    
    @Transactional(readOnly = true)
    public Optional<PeriodDto> findLast() {
        return this.repository.findFirstByFinishDateIsNotNullOrderByFinishDateDesc().map(this.mapper::toDto);
    }

    @Transactional
    public void delete(String id) {
        this.repository.deleteById( id );
    }
}
