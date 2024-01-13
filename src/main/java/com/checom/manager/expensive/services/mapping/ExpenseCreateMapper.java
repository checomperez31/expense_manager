package com.checom.manager.expensive.services.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.checom.manager.expensive.models.Expense;
import com.checom.manager.expensive.services.dto.ExpenseCreateDto;

@Mapper(componentModel = "spring")
public interface ExpenseCreateMapper extends ObjectMapper <ExpenseCreateDto, Expense> {
    
    @Mapping(source = "accountToTransfer", target = "accountDestination")
    Expense toEntity(ExpenseCreateDto dto);
}
