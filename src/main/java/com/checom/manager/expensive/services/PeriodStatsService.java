package com.checom.manager.expensive.services;

import org.mapstruct.Named;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.checom.manager.expensive.services.criteria.ExpenseCriteria;
import com.checom.manager.expensive.services.dto.StatsDto;
import com.checom.manager.expensive.utils.criteria.StringParamFilter;

@Service
public class PeriodStatsService {
    private final ExpenseService service;

    public PeriodStatsService(ExpenseService service) {
        this.service = service;
    }

    @Named("statsByPeriod")
    @Transactional(readOnly = true)
    public StatsDto getStatsByPeriod(String period) {
        ExpenseCriteria criteria = new ExpenseCriteria();
        StringParamFilter periodFilter = new StringParamFilter();
        periodFilter.setEqual( period );
        criteria.setPeriod( periodFilter );
        return this.service.getStats( criteria );
    }
}
