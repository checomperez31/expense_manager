package com.checom.manager.expensive.services.dto;

import java.time.ZonedDateTime;
import java.util.List;

import com.checom.manager.expensive.models.statsmodels.GastosExtended;

public class PeriodWithExpensesDto {
    private String id;

    private String description;

    private ZonedDateTime initDate;
    
    private ZonedDateTime finishDate;

    private List<GastosExtended> expenseTypes;

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

    public List<GastosExtended> getExpenseTypes() {
        return expenseTypes;
    }

    public void setExpenseTypes(List<GastosExtended> expenseTypes) {
        this.expenseTypes = expenseTypes;
    }

    
}
