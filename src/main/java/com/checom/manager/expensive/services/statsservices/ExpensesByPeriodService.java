package com.checom.manager.expensive.services.statsservices;

import java.util.List;

import org.mapstruct.Named;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.checom.manager.expensive.models.statsmodels.ExpensesByPeriod;
import com.checom.manager.expensive.repositories.statsrepositories.ExpensesByPeriodRepository;

@Service
public class ExpensesByPeriodService {
    private final ExpensesByPeriodRepository repository;

    public ExpensesByPeriodService(ExpensesByPeriodRepository repository) {
        this.repository = repository;
    }

    @Named("expensesByPeriod")
    @Transactional(readOnly = true)
    public List<ExpensesByPeriod> findAllByPeriod(String periodId) {
        return this.repository.findAllById_PeriodId( periodId );
    }
}
