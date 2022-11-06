package com.checom.manager.expensive.services.dto;

import java.io.Serializable;
import java.time.ZonedDateTime;

import lombok.Data;

@Data
public class PeriodCreateDto implements Serializable {
    private String id;

    private String description;

    private ZonedDateTime initDate;
    
    private ZonedDateTime finishDate;
    
}
