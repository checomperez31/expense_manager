package com.checom.manager.expensive.services;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.checom.manager.expensive.models.Account;
import com.checom.manager.expensive.models.Expense;
import com.checom.manager.expensive.repositories.ExpenseRepository;
import com.checom.manager.expensive.services.criteria.ExpenseCriteria;
import com.checom.manager.expensive.services.dto.ExpenseCreateDto;
import com.checom.manager.expensive.services.dto.StatsDto;
import com.checom.manager.expensive.services.mapping.ExpenseCreateMapper;

@Service
public class ExpenseService {

    private final ExpenseRepository repository;

    private final AccountService accountService;

    private final ExpenseCreateMapper createMapper;

    public ExpenseService(ExpenseRepository repository, AccountService accountService, ExpenseCreateMapper createMapper) {
        this.repository = repository;
        this.accountService = accountService;
        this.createMapper = createMapper;
    }

    @Transactional()
    public Expense create(ExpenseCreateDto dto) {
        Expense entity = this.createMapper.toEntity( dto );
        if ( entity.getMovementType() == null ) entity.setMovementType("G");
        if ( entity.getMovementType().equals("G") || entity.getMovementType().equals("T") ) {
            if ( entity.getAmount() > 0 ) entity.setAmount(entity.getAmount() * -1);
        } else {
            if ( entity.getAmount() < 0 ) entity.setAmount(entity.getAmount() * -1);
        }
        if (entity.getImpact() != null && entity.getImpact()) {
            Account account = this.accountService.findOne( entity.getAccount().getId() ).orElse(null);
            account.setAmount( account.getAmount() + entity.getAmount() );
            account = this.accountService.save(account);
            entity.setAccount(account);
        }
        entity = this.repository.save( entity );
        this.createTransferMovement( entity, dto.getAccountToTransfer() );
        return entity;
    }

    @Transactional()
    public void createTransferMovement(Expense origin, Account accountToTransfer) {
        Expense entity = new Expense();
        entity.setDescription( origin.getDescription() );
        entity.setType( origin.getType() );
        entity.setAmount(origin.getAmount() * -1);
        entity.setMovementType("T");
        entity.setImpact( origin.getImpact() );
        entity.setPeriod( origin.getPeriod() );
        entity.setExpenseDate( origin.getExpenseDate() );
        entity.setOrigin( origin );
        Account transferAccount = this.accountService.findOne( accountToTransfer.getId() ).orElse(null);
        if (entity.getImpact() != null && entity.getImpact()) {
            Double ammount = (transferAccount.getAmount() == null? 0: transferAccount.getAmount()) + entity.getAmount();
            transferAccount.setAmount( ammount );
            transferAccount = this.accountService.save(transferAccount);
            entity.setAccount( transferAccount );
        } else {
            entity.setAccount( transferAccount );
        }
        this.repository.save( entity );
    }

    @Transactional(readOnly = true)
    public Page<Expense> findAll(ExpenseCriteria criteria, Pageable pageable) {
        return this.repository.findAll(criteria.build(), pageable);
    }

    @Transactional(readOnly = true)
    public Optional<Expense> findOne(String id) {
        return this.repository.findById( id );
    }

    @Transactional
    public void delete(String id) {
        this.repository.deleteById( id );
    }

    @Transactional(readOnly = true)
    public StatsDto getStats(ExpenseCriteria criteria) {
        Double spent = this.repository.findAll(criteria.withMovementType("G").build())
            .stream().map(e -> Math.abs(e.getAmount())).reduce((a, b) -> {return a + b;}).orElse(Double.valueOf(0));
        Double ingress = this.repository.findAll(criteria.withMovementType("I").build())
            .stream().map(e -> Math.abs(e.getAmount())).reduce((a, b) -> {return a + b;}).orElse(Double.valueOf(0));
        return new StatsDto(ingress, spent);
    }
}
