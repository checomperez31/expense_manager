package com.checom.manager.expensive.services.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.checom.manager.expensive.models.Period;
import com.checom.manager.expensive.services.dto.PeriodWithExpensesDto;
import com.checom.manager.expensive.services.statsservices.ExpensesByPeriodService;

@Mapper(componentModel = "spring", uses = {ExpensesByPeriodService.class})
public interface PeriodExpensesMapper extends ObjectMapper<PeriodWithExpensesDto, Period> {
    @Mapping(source = "id", target = "expenseTypes", qualifiedByName = {"expensesByPeriod"})
    PeriodWithExpensesDto toDto(Period entity);
}
