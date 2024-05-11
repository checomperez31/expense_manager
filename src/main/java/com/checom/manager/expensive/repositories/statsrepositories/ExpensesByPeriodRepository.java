package com.checom.manager.expensive.repositories.statsrepositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.checom.manager.expensive.models.statsmodels.ExpensesByPeriod;
import com.checom.manager.expensive.models.statsmodels.ExpensesByPeriodId;

@Repository
public interface ExpensesByPeriodRepository extends JpaRepository<ExpensesByPeriod, ExpensesByPeriodId> {
    List<ExpensesByPeriod> findAllById_PeriodId(String periodId);
}
