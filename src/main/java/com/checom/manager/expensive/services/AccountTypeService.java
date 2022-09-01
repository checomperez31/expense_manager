package com.checom.manager.expensive.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.checom.manager.expensive.models.AccountType;
import com.checom.manager.expensive.repositories.AccountTypeRepository;

@Service
public class AccountTypeService {
    
    private final AccountTypeRepository repository;

    public AccountTypeService(AccountTypeRepository repository) {
        this.repository = repository;
    }

    @Transactional()
    public AccountType save(AccountType entity) {
        return this.repository.save( entity );
    }
    
    @Transactional(readOnly = true)
    public List<AccountType> findAll() {
        return this.repository.findAll();
    }
    
    @Transactional(readOnly = true)
    public Optional<AccountType> findOne(Integer id) {
        return this.repository.findById( id );
    }
    
    @Transactional()
    public void delete(Integer id) {
        this.repository.deleteById( id );
    }
}
