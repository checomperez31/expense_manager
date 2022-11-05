package com.checom.manager.expensive.services.mapping;

import org.mapstruct.Mapper;

import com.checom.manager.expensive.models.Period;
import com.checom.manager.expensive.services.dto.PeriodCreateDto;

@Mapper(componentModel = "spring")
public interface PeriodCreateMapper extends ObjectMapper<PeriodCreateDto, Period> {}
