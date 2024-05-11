package com.checom.manager.expensive.services.criteria;

import org.hibernate.tool.hbm2ddl.SchemaExportTask.ExportType;
import org.springframework.data.jpa.domain.Specification;

import com.checom.manager.expensive.models.Account_;
import com.checom.manager.expensive.models.Expense;
import com.checom.manager.expensive.models.ExpenseType_;
import com.checom.manager.expensive.models.Expense_;
import com.checom.manager.expensive.models.Period_;
import com.checom.manager.expensive.utils.criteria.Criteria;
import com.checom.manager.expensive.utils.criteria.ParamFilter;
import com.checom.manager.expensive.utils.criteria.StringParamFilter;

public class ExpenseCriteria extends Criteria<Expense> {
    private StringParamFilter account;
    private StringParamFilter period;
    private StringParamFilter movementType;
    private ParamFilter<Integer> type;

    public Specification<Expense> build () {
        Specification<Expense> spec = Specification.where(null);
        if ( account != null ) {
            spec = spec.and( createStringSpecificationList(account, Expense_.account, Account_.id) );
        }
        if ( period != null ) {
            spec = spec.and( createStringSpecificationList(period, Expense_.period, Period_.id ) );
        }
        if ( movementType != null ) {
            spec = spec.and( createStringSpecification(movementType, Expense_.movementType) );
        }
        if ( type != null ) {
            spec = spec.and( createSpecificationList(type, Expense_.type, ExpenseType_.id) );
        }
        spec = spec.and(buildOrder());
        return spec;
    }
    
    public Specification<Expense> buildStats() {
        Specification<Expense> spec = Specification.where(null);
        if ( account != null ) {
            spec = spec.and( createStringSpecificationList(account, Expense_.account, Account_.id) );
        }
        if ( period != null ) {
            spec = spec.and( createStringSpecificationList(period, Expense_.period, Period_.id ) );
        }
        if ( movementType != null ) {
            spec = spec.and( createStringSpecification(movementType, Expense_.movementType) );
        }
        return spec;
    }

    public Specification<Expense> buildOrder () {
        return (root, query, builder) -> {
            query.orderBy(builder.desc(root.get(Expense_.expenseDate)), builder.desc(root.get(Expense_.createdDate)));
            return builder.equal(builder.literal(1), 1);
        };
    }

    public StringParamFilter getAccount() {
        return account;
    }

    public void setAccount(StringParamFilter account) {
        this.account = account;
    }

    public StringParamFilter getPeriod() {
        return period;
    }

    public void setPeriod(StringParamFilter period) {
        this.period = period;
    }

    public StringParamFilter getMovementType() {
        return movementType;
    }

    public void setMovementType(StringParamFilter movementType) {
        this.movementType = movementType;
    }
    
    public ExpenseCriteria withMovementType(String movementType) {
        StringParamFilter mt = new StringParamFilter();
        mt.setEqual(movementType);
        ExpenseCriteria criteria = new ExpenseCriteria();
        criteria.setAccount(this.account);
        criteria.setPeriod(this.period);
        criteria.setMovementType(mt);
        return criteria;
    }

    public ParamFilter<Integer> getType() {
        return type;
    }

    public void setType(ParamFilter<Integer> type) {
        this.type = type;
    }

}
