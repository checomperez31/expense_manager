package com.checom.manager.expensive.repositories.statsrepositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.checom.manager.expensive.models.statsmodels.GlobalExpensesByType;

@Repository
public interface GlobalExpensesByTypeRepository extends JpaRepository<GlobalExpensesByType, Integer> {}
