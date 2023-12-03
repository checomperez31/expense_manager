package com.checom.manager.expensive.models.statsmodels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "global_expenses_by_type")
public class GlobalExpensesByType {

    @Id
    @Column(name="expense_type_id")
    private Integer id;

    @Column(name="description")
    private String description;

    @Column(name="amount")
    private Double amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    
}