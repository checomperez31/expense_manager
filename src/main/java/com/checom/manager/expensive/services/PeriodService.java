package com.checom.manager.expensive.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.checom.manager.expensive.models.Period;
import com.checom.manager.expensive.repositories.PeriodRepository;
import com.checom.manager.expensive.services.dto.PeriodCreateDto;
import com.checom.manager.expensive.services.dto.PeriodDto;
import com.checom.manager.expensive.services.dto.PeriodWithExpensesDto;
import com.checom.manager.expensive.services.mapping.PeriodCreateMapper;
import com.checom.manager.expensive.services.mapping.PeriodExpensesMapper;
import com.checom.manager.expensive.services.mapping.PeriodMapper;

@Service
public class PeriodService {
    private final PeriodRepository repository;
    private final PeriodCreateMapper createMapper;
    private final PeriodMapper mapper;
    private final PeriodExpensesMapper expensesMapper;

    public PeriodService(PeriodRepository repository, PeriodCreateMapper createMapper, PeriodMapper mapper, PeriodExpensesMapper expensesMapper) {
        this.repository = repository;
        this.createMapper = createMapper;
        this.mapper = mapper;
        this.expensesMapper = expensesMapper;
    }

    @Transactional
    public Period save(PeriodCreateDto dto) {
        return this.repository.save( this.createMapper.toEntity( dto ) );
    }

    @Transactional(readOnly = true)
    public Page<Period> findPage(Pageable pageable) {
        return this.repository.findAll(pageable);
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
    public List<PeriodWithExpensesDto> findAllDtoWithExpenses() {
        return this.expensesMapper.toDto(this.repository.findAll());
    }

    @Transactional(readOnly = true)
    public Optional<PeriodDto> findOne(String id) {
        return this.repository.findById( id ).map( this.mapper::toDto );
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
