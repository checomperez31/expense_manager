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

    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "period_id")
    private Period period;

    @Column(name = "expense_date")
    private ZonedDateTime expenseDate;
    
    @Column(name = "create_time")
    private ZonedDateTime createdDate;
    
    @Column(name = "create_user")
    private String createdUser;

    @Column(name = "update_time")
    private ZonedDateTime updatedDate;

    @Column(name = "update_user")
    private String updatedUser;

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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
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

    
}
