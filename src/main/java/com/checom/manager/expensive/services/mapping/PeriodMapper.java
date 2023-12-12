package com.checom.manager.expensive.services.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.checom.manager.expensive.models.Period;
import com.checom.manager.expensive.services.PeriodStatsService;
import com.checom.manager.expensive.services.dto.PeriodDto;

@Mapper(componentModel = "spring", uses = {PeriodStatsService.class})
public interface PeriodMapper extends ObjectMapper<PeriodDto, Period> {
    @Mapping(source = "id", target = "stats", qualifiedByName = {"statsByPeriod"})
    PeriodDto toDto(Period entity);
}
