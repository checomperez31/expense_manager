package com.checom.manager.expensive.repositories;

import org.springframework.stereotype.Repository;

@Repository
public class ExpenseRepository extends JpaRepository<Expense, Integer> {}
