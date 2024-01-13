package com.checom.manager.expensive.models;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "expense")
public class Expense {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name ="uuid2", strategy = "uuid2")
    private String id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    private String description;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private ExpenseType type;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Expense parent;

    private Double amount;

    @Column(name = "movement_type")
    private String movementType = "G";

    private Boolean impact = true;

    @ManyToOne
    @JoinColumn(name = "period_id")
    private Period period;

    @Column(name = "expense_date")
    private ZonedDateTime expenseDate;

    @ManyToOne
    @JoinColumn(name = "origin_id")
    private Expense origin;
    
    @CreatedDate
    @Column(name = "create_time", updatable = false)
    private ZonedDateTime createdDate = ZonedDateTime.now();
    
    @Column(name = "create_user")
    private String createdUser;

    @LastModifiedDate
    @Column(name = "update_time")
    private ZonedDateTime updatedDate = ZonedDateTime.now();

    @Column(name = "update_user")
    private String updatedUser;

    @ManyToOne
    @JoinColumn(name = "account_destination_id")
    private Account accountDestination;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public Expense getOrigin() {
        return origin;
    }

    public void setOrigin(Expense origin) {
        this.origin = origin;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public ZonedDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(ZonedDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedUser() {
        return updatedUser;
    }

    public void setUpdatedUser(String updatedUser) {
        this.updatedUser = updatedUser;
    }

    public Account getAccountDestination() {
        return accountDestination;
    }

    public void setAccountDestination(Account accountDestination) {
        this.accountDestination = accountDestination;
    }

    
}
