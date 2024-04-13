package com.checom.manager.expensive.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.checom.manager.expensive.models.Account;
import com.checom.manager.expensive.repositories.AccountRepository;

@Service
public class AccountService {

    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    @Transactional()
    public Account save(Account entity) {
        return this.repository.save( entity );
    }

    @Transactional(readOnly = true)
    public Page<Account> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Optional<Account> findOne(String id) {
        return this.repository.findById( id );
    }

    @Transactional()
    public void delete(String id) {
        this.repository.deleteById( id );
    }
}
