package com.checom.manager.expensive.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.checom.manager.expensive.models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {}
