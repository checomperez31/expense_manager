package com.checom.manager.expensive.services.dto;

public class StatsDto {
    private Double ingress;
    private Double expense;

    public StatsDto() {}

    public StatsDto(Double ingress, Double expense) {
        this.ingress = ingress;
        this.expense = expense;
    }

    public Double getIngress() {
        return ingress;
    }
    public void setIngress(Double ingress) {
        this.ingress = ingress;
    }
    public Double getExpense() {
        return expense;
    }
    public void setExpense(Double expense) {
        this.expense = expense;
    }
}
