package com.checom.manager.expensive.utils.criteria;

import java.util.function.Function;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public abstract class Criteria<ENTITY> {
    
    protected <X> Specification<ENTITY> equalsSpec(Function<Root<ENTITY>, Expression<X>> fn, final X value) {
        return (root, query, builder) -> builder.equal(fn.apply(root), value);
    }
    
    protected <X> Specification<ENTITY> likeSpec(Function<Root<ENTITY>, Expression<String>> fn, final String value) {
        return (root, query, builder) -> builder.like(builder.upper( fn.apply(root) ), this.getLikeString(value));
    }

    protected <X> Specification<ENTITY> createSpecification(ParamFilter<X> param, Function<Root<ENTITY>, Expression<X>> fn) {
        return this.equalsSpec(fn, param.getEqual());
    }
    
    protected <X> Specification<ENTITY> createStringSpec(StringParamFilter param, Function<Root<ENTITY>, Expression<String>> fn) {
        if (param.getEqual() != null) return this.equalsSpec(fn, param.getEqual());
        else if ( param.getLike() != null ) return this.likeSpec(fn, param.getLike());
        return null;
    }
    
    protected <X> Specification<ENTITY> createSpecification(ParamFilter<X> param, SingularAttribute<? super ENTITY, X> field) {
        return this.createSpecification(param, root -> root.get(field));
    }
    
    protected <X> Specification<ENTITY> createStringSpecification(StringParamFilter param, SingularAttribute<? super ENTITY, String> field) {
        return this.createStringSpec(param, root -> root.get(field));
    }

    protected <X> Specification<ENTITY> createSpecification(ParamFilter<X> param, SingularAttribute<? super ENTITY, X>... fields) {
        return this.createSpecification(param, root -> getPath(root, fields));
    }
    
    protected <X> Specification<ENTITY> createStringSpecificationList(StringParamFilter param, SingularAttribute<?, ?>... fields) {
        return this.createStringSpec(param, root -> getPath(root, fields));
    }
    
    protected <X> Specification<ENTITY> createSpecificationList(ParamFilter<X> param, SingularAttribute<?, ?>... fields) {
        return this.createSpecification(param, root -> getPath(root, fields));
    }

    protected Path getPath(Root<ENTITY> root, SingularAttribute... fields) {
        Path path = root;
        for (SingularAttribute field : fields) {
            path = path.get(field);
        }
        return path;
    }

    protected String getLikeString(String txt) {
        return "%" + txt.toUpperCase() + '%';
    }

}
