package com.checom.manager.expensive.services.dto;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class PeriodCreateDto implements Serializable {
    private String id;

    private String description;

    private ZonedDateTime initDate;
    
    private ZonedDateTime finishDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ZonedDateTime getInitDate() {
        return initDate;
    }

    public void setInitDate(ZonedDateTime initDate) {
        this.initDate = initDate;
    }

    public ZonedDateTime getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(ZonedDateTime finishDate) {
        this.finishDate = finishDate;
    }

    
    
}
