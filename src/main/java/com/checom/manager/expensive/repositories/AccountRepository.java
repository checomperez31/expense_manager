package com.checom.manager.expensive.repositories;

import org.springframework.stereotype.Repository;

@Repository
public class AccountRepository extends JpaRepository<Account, String> {}
