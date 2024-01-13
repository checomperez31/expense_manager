package com.checom.manager.expensive.services;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger log = LoggerFactory.getLogger( ExpenseService.class );

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
        entity = this.impact( entity );
        return entity;
    }

    @Transactional()
    public Expense update(ExpenseCreateDto dto) {
        Expense entity = this.createMapper.toEntity( dto );
        Expense exist = this.repository.findById( entity.getId() ).orElse( null );
        if ( exist != null ) this.reverseExpense( exist );
        return this.impact( entity );
    }

    @Transactional()
    public Expense impact(Expense entity) {
        if ( entity.getMovementType() == null ) entity.setMovementType("G");
        if ( entity.getMovementType().equals("G")) {
            entity.setAmount(Math.abs( entity.getAmount() ) * -1);
        } else {
            entity.setAmount(Math.abs( entity.getAmount() ));
        }
        Account account = this.accountService.findOne( entity.getAccount().getId() ).orElse(null);
        if (entity.getImpact() != null && entity.getImpact()) {
            Double ammount = (account.getAmount() == null? 0: account.getAmount());
            if ( entity.getMovementType().equals("G") ) {
                account.setAmount( ammount - Math.abs(entity.getAmount()) );
                entity.setAccountDestination( null );
            } else if ( entity.getMovementType().equals("T") ) {
                account.setAmount( ammount - Math.abs(entity.getAmount()) );

                Account accountDest = this.accountService.findOne( entity.getAccountDestination().getId() ).orElse(null);
                Double ammountDest = (accountDest.getAmount() == null? 0: accountDest.getAmount());
                accountDest.setAmount( ammountDest + Math.abs(entity.getAmount()) );
                accountDest = this.accountService.save( accountDest );
                entity.setAccountDestination(accountDest);
            } else {
                account.setAmount( ammount + Math.abs(entity.getAmount()) );
                entity.setAccountDestination( null );
            }
            account = this.accountService.save(account);
            entity.setAccount( account );
        }
        return this.repository.save( entity );
    }

    /*
     * This function reverse impact of movement in an account
     */
    @Transactional()
    public void reverseExpense(Expense entity) {
        Account account = this.accountService.findOne( entity.getAccount().getId() ).orElse(null);
        if ( entity.getMovementType() != null && account != null && entity.getImpact() ) {
            Double movementAmount = Math.abs( entity.getAmount() );
            if ( entity.getMovementType().equals( "G" ) ) {
                log.debug("Reversed account {} from {} to {}", account.getId(), account.getAmount(), (account.getAmount() + movementAmount));
                account.setAmount( account.getAmount() + movementAmount );
                this.accountService.save( account );
            } else if ( entity.getMovementType().equals( "I" ) ) {
                log.debug("Reversed account {} from {} to {}", account.getId(), account.getAmount(), (account.getAmount() - movementAmount));
                account.setAmount( account.getAmount() - movementAmount );
                this.accountService.save( account );
            } else {
                log.debug("Reversed account {} from {} to {}", account.getId(), account.getAmount(), (account.getAmount() + movementAmount));
                account.setAmount( account.getAmount() + movementAmount );
                this.accountService.save( account );

                Account transferedAccount = this.accountService.findOne( entity.getAccountDestination().getId() ).orElse(null);
                transferedAccount.setAmount( transferedAccount.getAmount() - movementAmount );
                this.accountService.save( transferedAccount );
            }
        }
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
        Double spent = this.repository.findAll(criteria.withMovementType("G").buildStats())
            .stream().map(e -> Math.abs(e.getAmount())).reduce((a, b) -> {return a + b;}).orElse(Double.valueOf(0));
        Double ingress = this.repository.findAll(criteria.withMovementType("I").buildStats())
            .stream().map(e -> Math.abs(e.getAmount())).reduce((a, b) -> {return a + b;}).orElse(Double.valueOf(0));
        return new StatsDto(ingress, spent);
    }
}
