package com.checom.manager.expensive.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.checom.manager.expensive.models.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, String> {
    List<Expense> findAllByAccountIsNotNullOrderByExpenseDateDescCreatedDateDesc();
}
