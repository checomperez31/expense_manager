package com.checom.manager.expensive.models.statsmodels;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class GastosExtendedId implements Serializable{

    @Column(name="account_id")
    private String accountId;

    @Column(name="period_id")
    private String periodId;

    @Column(name="expense_type_id")
    private Double expenseTypeId;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPeriodId() {
        return periodId;
    }

    public void setPeriodId(String periodId) {
        this.periodId = periodId;
    }

    public Double getExpenseTypeId() {
        return expenseTypeId;
    }

    public void setExpenseTypeId(Double expenseTypeId) {
        this.expenseTypeId = expenseTypeId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((accountId == null) ? 0 : accountId.hashCode());
        result = prime * result + ((periodId == null) ? 0 : periodId.hashCode());
        result = prime * result + ((expenseTypeId == null) ? 0 : expenseTypeId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GastosExtendedId other = (GastosExtendedId) obj;
        if (accountId == null) {
            if (other.accountId != null)
                return false;
        } else if (!accountId.equals(other.accountId))
            return false;
        if (periodId == null) {
            if (other.periodId != null)
                return false;
        } else if (!periodId.equals(other.periodId))
            return false;
        if (expenseTypeId == null) {
            if (other.expenseTypeId != null)
                return false;
        } else if (!expenseTypeId.equals(other.expenseTypeId))
            return false;
        return true;
    }

    
}