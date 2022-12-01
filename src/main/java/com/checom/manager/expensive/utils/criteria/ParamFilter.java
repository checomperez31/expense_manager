package com.checom.manager.expensive.utils.criteria;

import java.io.Serializable;
import java.util.List;

public class ParamFilter<FIELD_TYPE> implements Serializable {
    private FIELD_TYPE equal;
    private List<FIELD_TYPE> in;


    public FIELD_TYPE getEqual() {
        return this.equal;
    }

    public void setEqual(FIELD_TYPE equal) {
        this.equal = equal;
    }

    public List<FIELD_TYPE> getIn() {
        return this.in;
    }

    public void setIn(List<FIELD_TYPE> in) {
        this.in = in;
    }

}
