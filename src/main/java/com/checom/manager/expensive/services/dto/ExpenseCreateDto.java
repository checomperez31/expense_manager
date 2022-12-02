package com.checom.manager.expensive.services.dto;

import java.time.ZonedDateTime;

import com.checom.manager.expensive.models.Account;
import com.checom.manager.expensive.models.Expense;
import com.checom.manager.expensive.models.ExpenseType;
import com.checom.manager.expensive.models.Period;

public class ExpenseCreateDto {

    private Account account;

    private String description;

    private ExpenseType type;

    private Expense parent;

    private Double amount;

    private String movementType = "G";

    private Boolean impact = true;

    private Period period;

    private ZonedDateTime expenseDate;

    private Account accountToTransfer;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ExpenseType getType() {
        return type;
    }

    public void setType(ExpenseType type) {
        this.type = type;
    }

    public Expense getParent() {
        return parent;
    }

    public void setParent(Expense parent) {
        this.parent = parent;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getMovementType() {
        return movementType;
    }

    public void setMovementType(String movementType) {
        this.movementType = movementType;
    }

    public Boolean getImpact() {
        return impact;
    }

    public void setImpact(Boolean impact) {
        this.impact = impact;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public ZonedDateTime getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(ZonedDateTime expenseDate) {
        this.expenseDate = expenseDate;
    }

    public Account getAccountToTransfer() {
        return accountToTransfer;
    }

    public void setAccountToTransfer(Account accountToTransfer) {
        this.accountToTransfer = accountToTransfer;
    }
}
