package com.checom.manager.expensive.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.checom.manager.expensive.models.Account;
import com.checom.manager.expensive.models.Expense;
import com.checom.manager.expensive.repositories.ExpenseRepository;

@Service
public class ExpenseService {

    private final ExpenseRepository repository;
    private final AccountService accountService;

    public ExpenseService(ExpenseRepository repository, AccountService accountService) {
        this.repository = repository;
        this.accountService = accountService;
    }

    @Transactional()
    public Expense save(Expense entity) {
        if ( entity.getMovementType() == null ) entity.setMovementType("G");
        if ( entity.getMovementType().equals("G") ) {
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
        return this.repository.save( entity );
    }

    @Transactional(readOnly = true)
    public List<Expense> findAll() {
        return this.repository.findAllByAccountIsNotNullOrderByExpenseDateDescCreatedDateDesc();
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
