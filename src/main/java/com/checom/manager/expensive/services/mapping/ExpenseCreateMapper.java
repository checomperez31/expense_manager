package com.checom.manager.expensive.services.mapping;

import org.mapstruct.Mapper;

import com.checom.manager.expensive.models.Expense;
import com.checom.manager.expensive.services.dto.ExpenseCreateDto;

@Mapper(componentModel = "spring")
public interface ExpenseCreateMapper extends ObjectMapper <ExpenseCreateDto, Expense> {}
